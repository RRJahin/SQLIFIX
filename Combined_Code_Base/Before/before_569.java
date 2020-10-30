class Dummy{
public List<PlanInv> getPlanuriForSectie(SectieModel sectie) throws SQLException {
    ArrayList<PlanInv> result = new ArrayList<PlanInv>();
    String query = "SELECT * FROM ProgrameDeStudiu WHERE sectie_id = " + sectie.getId();
    Connection con = getConnection();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) {
        PlanInv plan = new PlanInv();
        plan.setDenumire(rs.getString("denumire_program"));
        plan.setId(rs.getInt("program_id"));
        plan.setSemestru(rs.getInt("semestru"));
        plan.getDisciplineInPlan().addAll(getDisciplineForPlan(plan));
        result.add(plan);
    }
    return result;
}}

