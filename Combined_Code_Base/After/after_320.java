public class Dummy{
@Override
public void borrar(Pelicula entidad) {
    try {
        String query = "DELETE FROM tbl_peliculas WHERE pk_pelicula = ?";
        conectar();
        PreparedStatement ps = getConexion().prepareStatement(query);
        ps.setObject(1, entidad.getIdPelicula());
        ps.execute();
        desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

