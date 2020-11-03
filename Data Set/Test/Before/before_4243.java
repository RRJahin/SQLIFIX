class Dummy{
public ResultSet getHabilidades(String id_guerrero) throws SQLException {
    Statement s = connection.createStatement();
    ResultSet rs = s.executeQuery("select * from habilidad where id_guerrero='" + id_guerrero + "'");
    return rs;
}}

