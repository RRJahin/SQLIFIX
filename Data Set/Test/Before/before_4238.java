class Dummy{
public int nuevaBatalla(String nombre, String id_villano, String id_heroe) throws SQLException {
    Statement stmt = connection.createStatement();
    int inserted = stmt.executeUpdate("insert into batalla (id_villano,id_heroe,nombrebatalla) values(" + id_villano + "," + id_heroe + ",'" + nombre + "')");
    connection.commit();
    int id_bat = 0;
    if (inserted == 1) {
stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select id_batalla from batalla where id_villano=" + id_villano + " and id_heroe=" + id_heroe + " and id_ganador is null");
        if (rs.next()) {
            id_bat = rs.getInt("id_batalla");
        }
    }
    stmt.close();
    return id_bat;
}}

