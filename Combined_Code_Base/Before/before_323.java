public class Dummy{
@Override
public boolean existe(Pelicula entidad) {
    String p = "";
    try {
        String query = "SELECT nombre FROM tbl_peliculas WHERE nombre = "+entidad.getNombre();
        conectar();
        Statement ps = getConexion().createStatement();
        setResultado(ps.executeQuery(query));
        while (getResultado().next()) {
            p = getResultado().getString("nombre");
        }
        desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return (!"".equals(p));
}}

