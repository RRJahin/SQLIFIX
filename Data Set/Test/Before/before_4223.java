class Dummy{
public ResultSet getGraficosTablas(Integer idTabla) {
    ResultSet rsSalida = null;
    try {
        Statement statement = dbconn.createStatement();
        String cQuery = "select tg.idgrafico,tg.idtabla, tg.imprime_titulos, t.tabla,g.grafico,g.query_consulta,g.idtipografico,ttg.tipografico,g.iddatasource, g.query_consulta2, g.query_consulta3 from tablas_graficos tg, tablas t, grafico g, tipo_grafico ttg where   tg.idtabla = " + idTabla + " and tg.idtabla = t.idtabla  and tg.idgrafico = g.idgrafico  and g.idtipografico = ttg.idtipografico order by tg.orden";
        rsSalida = statement.executeQuery(cQuery);
    } catch (SQLException sqlException) {
        log.error("Error SQL getGraficosTablas( Integer idTabla ): " + sqlException);
    } catch (Exception ex) {
        log.error("Salida por exception getGraficosTablas( Integer idTabla ): " + ex);
    }
    return rsSalida;
}}

