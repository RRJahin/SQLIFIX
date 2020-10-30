public class Dummy{
@Override
public Persona obtener(int id) {
    if (!abrirConexion()) {
        return null;
    }
    Persona persona = null;
    String query = "select id,nombre,edad,peso from personas where id =?";
    try {
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setObject(1, id);
        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            persona = new Persona();
            persona.setId(rs.getInt(1));
            persona.setNombre(rs.getString(2));
            persona.setEdad(rs.getInt(3));
            persona.setPeso(rs.getDouble(4));
        }
    } catch (SQLException e) {
        System.out.println("obtener -> error al obtener la persona con id " + id);
        e.printStackTrace();
        persona = null;
    } finally {
        cerrarConexion();
    }
    return persona;
}}

