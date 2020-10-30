class Dummy{
public void deleteCercStud(CercStudentesc cerc) throws SQLException {
    Connection con = getConnection();
    con.setAutoCommit(false);
    try {
        String query = "DELETE FROM Projects WHERE id =  ?" ;
        PreparedStatement stmt = con.prepareStatement();
        stmt.setObject(1,cerc.getId());
        stmt.executeUpdate(query);
        con.commit();
    } catch (SQLException e) {
        con.rollback();
        throw e;
    }
}}

