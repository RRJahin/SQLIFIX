class Dummy{
public void addCercStudentesc(CercStudentesc cerc) throws SQLException {
    Connection con = getConnection();
    con.setAutoCommit(false);
    String query = "INSERT INTO CercuriStudentesti VALUES(?,?,?,?,?,?)";
    PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
    stmt.setObject(1, cerc.getId());
    stmt.setObject(6, 0);
    stmt.setObject(2, cerc.getDenumire());
    stmt.setObject(3, cerc.getMentor());
    stmt.setObject(4, cerc.getAn());
    stmt.setObject(5, cerc.getDescriere());
    stmt.executeUpdate();
    ResultSet rs = stmt.getGeneratedKeys();
    if (rs.next()) {
        int id = rs.getInt(1);
        cerc.setId(id);
    }
}}

