class Dummy{
public void deletePlanInv(PlanInv plan, Connection connection) throws SQLException {
    String query = "DELETE FROM PlanuriInvatamint WHERE program_id = " + plan.getId();
    Statement stmt = connection.createStatement();
    stmt.executeUpdate(query);
    query = "DELETE FROM ProgrameDeStudiu WHERE program_id = " + plan.getId();
    stmt = connection.createStatement();
    stmt.executeUpdate(query);
}}

