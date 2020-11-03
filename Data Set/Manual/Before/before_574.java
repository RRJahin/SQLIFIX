class Dummy{
public void deleteSectie(SectieModel sectie) throws SQLException {
    String query = "DELETE FROM Sectii WHERE Id_Sectie = " + sectie.getId();
    Connection con = getConnection();
    con.setAutoCommit(false);
    Statement stmt = con.createStatement();
    for (PlanInv plan : sectie.getPlanuriDeInvatamint()) {
        deletePlanInv(plan, con);
    }
    stmt.executeUpdate(query);
    con.commit();
}}

