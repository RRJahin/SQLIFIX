import java.sql.PreparedStatement;

class Dummy{
public ObservableList<Cotizacion> getCotizaciones(int idrequisicion, Conexion con) throws SQLException {
    ObservableList<Cotizacion> lista = FXCollections.observableArrayList();
    String sql = "SELECT * FROM cotizaciones WHERE idrequisicion=?" ;
    PreparedStatement pssql = con.prepareStatement(sql);
    pssql.setObject(1, idrequisicion);
    ResultSet rs = pssql.executeQuery();
    while (rs.next()) {
        Cotizacion cot = new Cotizacion();
        cot.setId(rs.getInt("idcotizacion"));
        cot.setArchivo(rs.getBytes("archivo"));
        cot.setFormato(rs.getString("formato"));
        cot.setNombre(rs.getString("nombrearchivo"));
        cot.setFecha(rs.getTimestamp("fechaderegistro").toLocalDateTime());
        lista.add(cot);
    }
    return lista;
}}

