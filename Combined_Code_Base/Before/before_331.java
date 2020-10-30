public class Dummy{
@Override
public boolean modificar(Persona p) {
    if (!abrirConexion()) {
        return false;
    }
    boolean modificado = true;
    String query = "update personas set NOMBRE="+p.getNombre()+", EDAD="+p.getEdad()+", PESO="+p.getPeso()+" where id="+p.getId();
    try {
        Statement ps = conexion.createStatement();
        int numeroFilasAfectadas = ps.executeUpdate(query);
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

