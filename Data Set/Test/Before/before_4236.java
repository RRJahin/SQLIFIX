class Dummy{
public String regHabilidad(String id_guerrero, String nombre, String ptsfuerza, String tipo) {
    ResultSet rs = null;
    try {
        Statement stmt = connection.createStatement();
        int inserted = stmt.executeUpdate("insert into habilidad (id_guerrero,nombre,ptsfuerza,tipo) values(" + id_guerrero + ",'" + nombre + "'," + ptsfuerza + "," + tipo + ")");
        connection.commit();
        stmt.close();
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "Ok";
}}

