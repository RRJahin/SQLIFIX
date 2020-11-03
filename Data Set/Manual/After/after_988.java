public class Dummy{
@Override
public Pelicula modificar(Pelicula entidad) {
    try {
        String query = "UPDATE tbl_peliculas SET nombre = ?, genero = ?, clasificacion = ?, duracion = ?, imagen = ? WHERE pk_pelicula = ?";
        conectar();
        PreparedStatement ps = getConexion().prepareStatement(query);
        ps.setObject(1, entidad.getNombre());
        ps.setObject(2, entidad.getGenero());
        ps.setObject(3, entidad.getClasificacion());
        ps.setObject(4, entidad.getDuracion());
        ps.setObject(5, entidad.getImagen());
        ps.setObject(6, entidad.getIdPelicula());
        ps.execute();
        desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return entidad;
}}

