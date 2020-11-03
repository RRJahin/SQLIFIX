public class Dummy{
@Override
public boolean baja(int id) {
    if (!abrirConexion()) {
        return false;
    }
    boolean borrado = true;
    String query = "delete from personas where id = ?";
    try {
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setObject(1, id);
        int numeroFilasAfectadas = ps.executeUpdate();
        if (numeroFilasAfectadas == 0) {
            borrado = false;
        } else {
            borrado = true;
        }
    } catch (SQLException e) {
        System.out.println("baja -> No se ha podido dar de baja el id: " + id);
        e.printStackTrace();
        borrado = false;
    } finally {
        cerrarConexion();
    }
    return borrado;
}}

