class Dummy{
public List<PlanInv> getPlanuriForSectie(SectieModel sectie) throws SQLException {
    ArrayList<PlanInv> result = new ArrayList<PlanInv>();
    String query = "SELECT * FROM ProgrameDeStudiu WHERE sectie_id = ?"  ;
    Connection con = getConnection();
    PreparedStatement stmt = con.prepareStatement(query);
    stmt.setObject(1,sectie.getId());
    ResultSet rs = stmt.executeQuery();
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

