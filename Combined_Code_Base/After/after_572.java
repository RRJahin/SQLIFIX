class Dummy{
public void insertPlan(PlanInv plan, SectieModel sectie, Connection connection) throws SQLException {
    String query = "INSERT INTO ProgrameDeStudiu VALUES (?,?,?)";
    PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    stmt.setObject(1, sectie.getId());
    stmt.setObject(2, plan.getDenumire());
    stmt.setObject(3, plan.getSemestru());
    stmt.executeUpdate();
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

