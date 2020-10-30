class Dummy{
public void insertDisciplineIntoPlan(DisciplinePlan disc, PlanInv plan, Connection connection) throws SQLException {
    String query = "INSERT INTO PlanuriInvatamint VALUES("plan.getId()+","+ disc.getDisc()+","+disc.getOreCurs()+","+disc.getOreSem()+","+disc.getOreLab()+","+disc.getOrePr()+","+disc.getFinalizare()+","+disc.getNrCredite()+")";
    Statement stmt = connection.createStatement();
    stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
    ResultSet rs = stmt.getGeneratedKeys();
}}

