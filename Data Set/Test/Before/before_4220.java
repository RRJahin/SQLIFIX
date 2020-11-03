class Dummy{
public boolean hasTablasReportes(Integer idReporte) {
    ResultSet rsSalida = null;
    try {
        Statement statement = dbconn.createStatement();
        String cQuery = "select count(*) as total from  reportes_tablas where idreporte = " + idReporte;
        rsSalida = statement.executeQuery(cQuery);
        if (rsSalida != null && rsSalida.next()) {
            int total = rsSalida.getInt("total");
            if (total > 0)
                return true;
        }
        return false;
    } catch (SQLException sqlException) {
        log.error("Error SQL: " + sqlException);
        return false;
    } catch (Exception ex) {
        log.error("Salida por exception: " + ex);
        return false;
    }
}}

