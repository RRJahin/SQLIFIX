class Dummy{
public void insertSectie(SectieModel sectie) throws SQLException {
    String query = "INSERT INTO Sectii VALUES (?,?)";
    Connection con = getConnection();
    con.setAutoCommit(false);
    PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    stmt.setObject(2, sectie.getNrSemestre());
    stmt.setObject(1, sectie.getDenumire());
    stmt.executeUpdate();
    ResultSet rs = stmt.getGeneratedKeys();
    int id = -1;
    if (rs.next()) {
        id = rs.getInt(1);
    }
    sectie.setId(id);
    for (PlanInv plan : sectie.getPlanuriDeInvatamint()) {
        insertPlan(plan, sectie, con);
    }
    con.commit();
}}

