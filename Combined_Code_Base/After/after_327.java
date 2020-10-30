public class Dummy{
@Override
public boolean alta(Persona p) {
    if (!abrirConexion()) {
        return false;
    }
    boolean alta = true;
    String query = "insert into personas (NOMBRE,EDAD,PESO)" + "values (?,?,?)";
    try {
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setObject(1, p.getNombre());
        ps.setObject(2, p.getEdad());
        ps.setObject(3, p.getPeso());
        int numeroFilasAfectadas = ps.executeUpdate();
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

