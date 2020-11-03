public class Dummy{
@Override
public boolean alta(Persona p) {
    if (!abrirConexion()) {
        return false;
    }
    boolean alta = true;
    String query = "insert into personas (NOMBRE,EDAD,PESO)" + "values ("+p.getNombre()+","+p.getEdad()+","+p.getPeso()+")";
    try {
        Statement ps = conexion.createStatement();
        int numeroFilasAfectadas = ps.executeUpdate(query);
        if (numeroFilasAfectadas == 0) {
            alta = false;
        } else {
            alta = true;
        }
    } catch (SQLException e) {
        System.out.println("alta -> Error al insertar: " + p);
        alta = false;
        e.printStackTrace();
    } finally {
        cerrarConexion();
    }
    return alta;
}}

