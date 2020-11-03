class Dummy{
public boolean hasGraficosTablas(Integer idTabla) {
    ResultSet rsSalida = null;
    try {
        Statement statement = dbconn.createStatement();
        String cQuery = "select count(*) as total from tablas_graficos  where  idtabla = " + idTabla;
        rsSalida = statement.executeQuery(cQuery);
        if (rsSalida != null && rsSalida.next()) {
            int total = rsSalida.getInt("total");
            if (total > 0)
                return true;
        }
        return false;
    } catch (SQLException sqlException) {
        log.error("Error SQL getGraficosTablas( Integer idTabla ): " + sqlException);
        return false;
    } catch (Exception ex) {
        log.error("Salida por exception getGraficosTablas( Integer idTabla ): " + ex);
        return false;
    }
}}

