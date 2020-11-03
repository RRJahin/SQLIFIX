class Dummy{
public String getVida(String id_guerrero) throws SQLException {
    Statement s = connection.createStatement();
    ResultSet rs = s.executeQuery("select ptsvida from guerrero where id_guerrero='" + id_guerrero + "'");
    rs.next();
    return rs.getString("ptsvida");
}}

