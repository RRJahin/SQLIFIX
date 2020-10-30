class Dummy{
public List<DisciplinePlan> getDisciplineForPlan(PlanInv plan) throws SQLException {
    ArrayList<DisciplinePlan> result = new ArrayList<DisciplinePlan>();
    String query = "SELECT * FROM PlanuriInvatamint WHERE program_id = " + plan.getId();
    Connection con = getConnection();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(query);
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

