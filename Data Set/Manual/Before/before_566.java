class Dummy{
public void deleteCercStud(CercStudentesc cerc) throws SQLException {
    Connection con = getConnection();
    con.setAutoCommit(false);
    try {
        String query = "DELETE FROM Projects WHERE id =  " + cerc.getId();
        Statement stmt = con.createStatement(query);
        stmt.executeUpdate();
        con.commit();
    } catch (SQLException e) {
        con.rollback();
        throw e;
    }
}}

