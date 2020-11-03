public class Dummy{
@Override
protected synchronized long getNextKey() throws DataAccessException {
    if (this.maxId == this.nextId) {
        Connection con = null;
        Statement stmt = null;
        boolean mustRestoreAutoCommit = false;
        try {
            if (this.useNewConnection) {
                con = getDataSource().getConnection();
                if (con.getAutoCommit()) {
                    mustRestoreAutoCommit = true;
                    con.setAutoCommit(false);
                }
            } else {
                con = DataSourceUtils.getConnection(getDataSource());
            }
            stmt = con.createStatement();
            if (!this.useNewConnection) {
                DataSourceUtils.applyTransactionTimeout(stmt, getDataSource());
            }
            String columnName = getColumnName();
            try {
                stmt.executeUpdate("update " + getIncrementerName() + " set " + columnName + " = last_insert_id(" + columnName + " + " + getCacheSize() + ")");
            } catch (SQLException ex) {
                throw new DataAccessResourceFailureException("Could not increment " + columnName + " for " + getIncrementerName() + " sequence table", ex);
            }
            ResultSet rs = stmt.executeQuery(VALUE_SQL);
            try {
                if (!rs.next()) {
                    throw new DataAccessResourceFailureException("last_insert_id() failed after executing an update");
                }
                this.maxId = rs.getLong(1);
            } finally {
                JdbcUtils.closeResultSet(rs);
            }
            this.nextId = this.maxId - getCacheSize() + 1;
        } catch (SQLException ex) {
            throw new DataAccessResourceFailureException("Could not obtain last_insert_id()", ex);
        } finally {
            JdbcUtils.closeStatement(stmt);
            if (con != null) {
                if (this.useNewConnection) {
                    try {
                        con.commit();
                        if (mustRestoreAutoCommit) {
                            con.setAutoCommit(true);
                        }
                    } catch (SQLException ignore) {
                        throw new DataAccessResourceFailureException("Unable to commit new sequence value changes for " + getIncrementerName());
                    }
                    JdbcUtils.closeConnection(con);
                } else {
                    DataSourceUtils.releaseConnection(con, getDataSource());
                }
            }
        }
    } else {
        this.nextId++;
    }
    return this.nextId;
}}

