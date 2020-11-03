class Dummy{
public String regGuerrero(String id_maestro, String ptsvida, String nombre, String url_foto) {
    ResultSet rs = null;
    try {
        Statement stmt = connection.createStatement();
        int inserted = stmt.executeUpdate("insert into guerrero(id_maestro,nombre,ptsvida,url_foto) values(" + id_maestro + ",'" + nombre + "'," + ptsvida + ",'" + url_foto + "')");
        connection.commit();
        stmt.close();
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "Ok";
}}

