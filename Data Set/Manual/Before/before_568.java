class Dummy{
public void addCercStudentesc(CercStudentesc cerc) throws SQLException {
    Connection con = getConnection();
    con.setAutoCommit(false);
    String query = "INSERT INTO CercuriStudentesti VALUES("+cerc.getId()+","+cerc.getDenumire()+","+cerc.getMentor()+","+cerc.getAn()+","+cerc.getDescriere()+",0)";
    Statement stmt = con.createStatement();
    stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
    ResultSet rs = stmt.getGeneratedKeys();
    if (rs.next()) {
        int id = rs.getInt(1);
        cerc.setId(id);
    }
}}

