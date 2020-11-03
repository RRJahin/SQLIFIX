class Dummy{
public void deletePlanInv(PlanInv plan, Connection connection) throws SQLException {
    String query = "DELETE FROM PlanuriInvatamint WHERE program_id = ?" ;
    PreparedStatement stmt = connection.prepareStatement(query);
    stmt.setObject(1,plan.getId());
    stmt.executeUpdate();
    query = "DELETE FROM ProgrameDeStudiu WHERE program_id = ?" ;
    stmt.setObject(1,plan.getId());
    stmt = connection.prepareStatement(query);
    stmt.executeUpdate();
}}

