class Dummy{
public ResultSet getEnemigos(boolean esVillano) throws SQLException {
    Statement s = connection.createStatement();
    ResultSet rs = null;
    if (esVillano) {
s = connection.createStatement();
        rs = s.executeQuery("select g.id_guerrero id, m.pseudonimo maestro, g.nombre guerrero from guerrero g inner join maestro m on g.id_maestro = m.id_maestro where m.tipo = 1 and g.ptsvida > 0");
    } else {
        rs = s.executeQuery("select g.id_guerrero id, m.pseudonimo maestro, g.nombre guerrero from guerrero g inner join maestro m on g.id_maestro = m.id_maestro where m.tipo = 0 and g.ptsvida > 0");
    }
    return rs;
}}

