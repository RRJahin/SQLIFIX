class Dummy{
public ResultSet getContrincantes(String id_maestro) throws SQLException {
    Statement s = connection.createStatement();
    ResultSet rs;
    rs = s.executeQuery("select tipo from maestro where id_maestro=" + id_maestro);
    rs.next();
    String tipo = rs.getString("tipo");
    if (tipo.compareTo("0") == 0) {
        rs = s.executeQuery("select pseudonimo from (select id_maestro from(select id_heroe from(select id_guerrero from guerrero where guerrero.id_maestro=" + id_maestro + ") s,batalla b where s.id_guerrero=b.id_villano) s1, guerrero g where s1.id_heroe=g.id_guerrero ) s2, maestro m where s2.id_maestro=m.id_maestro group by pseudonimo");
s = connection.createStatement();
        return rs;
    } else {
s = connection.createStatement();
        rs = s.executeQuery("select pseudonimo from (select id_maestro from(select id_villano from(select id_guerrero from guerrero where guerrero.id_maestro=" + id_maestro + ") s,batalla b where s.id_guerrero=b.id_heroe) s1, guerrero g where s1.id_villano=g.id_guerrero ) s2, maestro m where s2.id_maestro=m.id_maestro group by pseudonimo");
        return rs;
    }
}}

