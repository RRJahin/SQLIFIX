class Dummy{
public List getReportesPK(long idReporte) throws EJBException {
    ResultSet rsSalida = null;
    String cQuery = "Select * from reportes where idreporte = " + idReporte;
    List vecSalida = new ArrayList();
    try {
        Statement statement = dbconn.createStatement();
        rsSalida = statement.executeQuery(cQuery);
        ResultSetMetaData md = rsSalida.getMetaData();
        while (rsSalida.next()) {
            int totCampos = md.getColumnCount() - 1;
            String[] sSalida = new String[totCampos + 1];
            int i = 0;
            while (i <= totCampos) {
                sSalida[i] = rsSalida.getString(++i);
            }
            vecSalida.add(sSalida);
        }
    } catch (SQLException sqlException) {
        log.error("Error SQL: " + sqlException);
    } catch (Exception ex) {
        log.error("Salida por exception: " + ex);
    }
    return vecSalida;
}}

