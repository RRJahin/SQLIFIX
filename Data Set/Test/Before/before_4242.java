class Dummy{
public ResultSet getGuerreros(String id_maestro) throws SQLException {
    Statement s = connection.createStatement();
    ResultSet rs = s.executeQuery("select * from guerrero where id_maestro='" + id_maestro + "' and ptsvida>0 and ptsvida<11");
    return rs;
}}

