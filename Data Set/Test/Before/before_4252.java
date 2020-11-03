class Dummy{
public boolean sinBatalla(String guerrero) throws SQLException {
    Statement s = connection.createStatement();
    ResultSet rs = s.executeQuery("select * from batalla where (id_heroe='" + guerrero + "' or id_villano='" + guerrero + "') and id_ganador is null");
    boolean sin = true;
    if (rs.next()) {
        sin = false;
    }
    return sin;
}}

