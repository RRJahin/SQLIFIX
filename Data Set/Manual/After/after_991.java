public class Dummy{
public Pelicula dameXId(int id) {
    Pelicula entidad = new Pelicula();
    try {
        String query = "SELECT * FROM tbl_peliculas WHERE pk_pelicula = ?";
        conectar();
        PreparedStatement ps = getConexion().prepareStatement(query);
        ps.setObject(1, id);
        setResultado(ps.executeQuery());
        while (getResultado().next()) {
            entidad.setIdPelicula(getResultado().getInt("pk_pelicula"));
            entidad.setNombre(getResultado().getString("nombre"));
            entidad.setGenero(getResultado().getString("genero"));
            entidad.setClasificacion(getResultado().getString("clasificacion"));
            entidad.setDuracion(getResultado().getInt("duracion"));
            entidad.setImagen(getResultado().getString("imagen"));
        }
        desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return (entidad);
}}

