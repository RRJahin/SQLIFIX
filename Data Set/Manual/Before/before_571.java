class Dummy{
public void insertSectie(SectieModel sectie) throws SQLException {
    String query = "INSERT INTO Sectii VALUES ("+sectie.getDenumire()+","+sectie.getNrSemestre()+")";
    Connection con = getConnection();
    con.setAutoCommit(false);
    Statement stmt = con.createStatement();
    stmt.setInt(2, );
    stmt.setString(1, );
    stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
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

