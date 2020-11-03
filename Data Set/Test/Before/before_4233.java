class Dummy{
public int numGuerreros(String id_maestro) throws SQLException {
    Statement s = connection.createStatement();
    ResultSet rs = s.executeQuery("SELECT COUNT(*) AS conteo FROM guerrero WHERE id_maestro=" + id_maestro);
    rs.next();
    return rs.getInt("conteo");
}}

