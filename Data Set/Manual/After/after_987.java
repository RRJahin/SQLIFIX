public class Dummy{
@Override
public Pelicula agregar(Pelicula entidad) {
    if (!this.existe(entidad)) {
        try {
            String query = "INSERT INTO tbl_peliculas (nombre, genero, clasificacion, duracion, imagen) VALUES (?, ?, ?, ?, ?)";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setObject(1, entidad.getNombre());
            ps.setObject(2, entidad.getGenero());
            ps.setObject(3, entidad.getClasificacion());
            ps.setObject(4, entidad.getDuracion());
            ps.setObject(5, entidad.getImagen());
            ps.execute();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return entidad;
}}

