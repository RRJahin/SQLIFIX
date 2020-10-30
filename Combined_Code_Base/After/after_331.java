public class Dummy{
@Override
public boolean modificar(Persona p) {
    if (!abrirConexion()) {
        return false;
    }
    boolean modificado = true;
    String query = "update personas set NOMBRE=?, EDAD=?, PESO=? where id=?";
    try {
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setObject(1, p.getNombre());
        ps.setObject(2, p.getEdad());
        ps.setObject(3, p.getPeso());
        ps.setObject(4, p.getId());
        int numeroFilasAfectadas = ps.executeUpdate();
        if (numeroFilasAfectadas == 0) {
            modificado = false;
        } else {
            modificado = true;
        }
    } catch (SQLException e) {
        System.out.println("modificar -> error al modificar la persona: " + p);
        e.printStackTrace();
        modificado = false;
    } finally {
        cerrarConexion();
    }
    return modificado;
}}

