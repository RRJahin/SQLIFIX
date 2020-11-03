class Dummy{
public ResultSet getTablasReportes(Integer idReporte) {
    ResultSet rsSalida = null;
    try {
        Statement statement = dbconn.createStatement();
        String cQuery = "select rt.idreporte,rt.imprime_titulos, r.reporte, r.comentario, t.idtabla, t.tabla, t.query_carga, t.query_consulta, t.iddatasource from  reportes_tablas rt,  reportes r,  tablas t where rt.idreporte = " + idReporte + " and rt.idreporte = r.idreporte and rt.idtabla = t.idtabla order by rt.orden";
        rsSalida = statement.executeQuery(cQuery);
    } catch (SQLException sqlException) {
        log.error("Error SQL: " + sqlException);
    } catch (Exception ex) {
        log.error("Salida por exception: " + ex);
    }
    return rsSalida;
}}

