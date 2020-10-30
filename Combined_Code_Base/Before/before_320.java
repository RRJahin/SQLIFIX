public class Dummy{
@Override
public void borrar(Pelicula entidad) {
    try {
        String query = "DELETE FROM tbl_peliculas WHERE pk_pelicula = "+entidad.getIdPelicula();
        conectar();
        Statement ps = getConexion().createStatement();
        ps.execute(query);
        desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

