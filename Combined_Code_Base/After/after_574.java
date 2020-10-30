class Dummy{
public void deleteSectie(SectieModel sectie) throws SQLException {
    String query = "DELETE FROM Sectii WHERE Id_Sectie = ?"  ;
    Connection con = getConnection();
    con.setAutoCommit(false);
    PreparedStatement stmt = con.prepareStatement(query);
    stmt.setObject(1,sectie.getId());
    for (PlanInv plan : sectie.getPlanuriDeInvatamint()) {
        deletePlanInv(plan, con);
    }
    stmt.executeUpdate();
    con.commit();
}}

