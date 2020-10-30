class Dummy{
public void insertPlan(PlanInv plan, SectieModel sectie, Connection connection) throws SQLException {
    String query = "INSERT INTO ProgrameDeStudiu VALUES ("+sectie.getId()+","+plan.getDenumire()+","+plan.getSemestru()+")";
    Statement stmt = connection.createStatement();
    stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
    ResultSet rs = stmt.getGeneratedKeys();
    int id = -1;
    if (rs.next()) {
        id = rs.getInt(1);
    }
    plan.setId(id);
    for (DisciplinePlan disc : plan.getDisciplineInPlan()) {
        insertDisciplineIntoPlan(disc, plan, connection);
    }
}}

