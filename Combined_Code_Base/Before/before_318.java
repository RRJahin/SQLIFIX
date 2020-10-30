public class Dummy{
@Override
public Pelicula agregar(Pelicula entidad) {
    if (!this.existe(entidad)) {
        try {
            String query = "INSERT INTO tbl_peliculas (nombre, genero, clasificacion, duracion, imagen) VALUES ("+entidad.getNombre()+", "+entidad.getGenero()+", "+entidad.getClasificacion()+", "+entidad.getDuracion()+", "+entidad.getImagen()+")";
            conectar();
            Statement ps = getConexion().createStatement();
            ps.execute(query);
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return entidad;
}}

