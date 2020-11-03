class Dummy{
public List<DisciplinePlan> getDisciplineForPlan(PlanInv plan) throws SQLException {
    ArrayList<DisciplinePlan> result = new ArrayList<DisciplinePlan>();
    String query = "SELECT * FROM PlanuriInvatamint WHERE program_id = ?" ;
    Connection con = getConnection();
    PreparedStatement stmt = con.prepareStatement(query);
    stmt.setObject(1, plan.getId());
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
        DisciplinePlan disc = new DisciplinePlan();
        disc.setDisc(rs.getString("disciplina"));
        disc.setFinalizare(rs.getString("finalizare"));
        disc.setNrCredite(rs.getInt("nr_credite"));
        disc.setOreCurs(rs.getInt("ore_curs"));
        disc.setOreLab(rs.getInt("ore_lab"));
        disc.setOrePr(rs.getInt("ore_pr"));
        disc.setOreSem(rs.getInt("ore_sem"));
        result.add(disc);
    }
    return result;
}}

