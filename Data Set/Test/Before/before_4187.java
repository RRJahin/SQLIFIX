class Dummy{
private synchronized void initCollElemTypeName() throws SQLException {
    Statement stmt = this.connection.createStatement();
    ResultSet rset = stmt.executeQuery("SELECT ELEM_TYPE_NAME, ELEM_TYPE_OWNER FROM ALL_COLL_TYPES WHERE TYPE_NAME='" + this.sqlName.getSimpleName() + "' AND OWNER='" + this.sqlName.getSchema() + "'");
    if (rset.next()) {
        if (this.attrTypeNames == null) {
            this.attrTypeNames = new String[1];
        }
        this.attrTypeNames[0] = (rset.getString(2) + "." + rset.getString(1));
    } else {
        DatabaseError.throwSqlException(1);
    }
    rset.close();
    stmt.close();
}}

