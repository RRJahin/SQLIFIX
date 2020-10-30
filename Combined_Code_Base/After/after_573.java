class Dummy{
public void insertDisciplineIntoPlan(DisciplinePlan disc, PlanInv plan, Connection connection) throws SQLException {
    String query = "INSERT INTO PlanuriInvatamint VALUES(?,?,?,?,?,?,?,?)";
    PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    stmt.setObject(1, plan.getId());
    stmt.setObject(2, disc.getDisc());
    stmt.setObject(3, disc.getOreCurs());
    stmt.setObject(4, disc.getOreSem());
    stmt.setObject(5, disc.getOreLab());
    stmt.setObject(6, disc.getOrePr());
    stmt.setObject(7, disc.getFinalizare());
    stmt.setObject(8, disc.getNrCredite());
    stmt.executeUpdate();
    ResultSet rs = stmt.getGeneratedKeys();
}}

