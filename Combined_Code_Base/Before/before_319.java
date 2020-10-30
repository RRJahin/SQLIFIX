public class Dummy{
@Override
public Pelicula modificar(Pelicula entidad) {
    try {
        String query = "UPDATE tbl_peliculas SET nombre = "+entidad.getNombre()+", genero = "+entidad.getGenero()+", clasificacion = "+entidad.getClasificacion()+", duracion = "+entidad.getDuracion()+", imagen = "+entidad.getImagen()+" WHERE pk_pelicula = "+entidad.getIdPelicula();
        conectar();
        Statement ps = getConexion().createStatement();
        ps.execute(query);
        desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return entidad;
}}

