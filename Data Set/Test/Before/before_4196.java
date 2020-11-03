class Dummy{
public List getMonedas(BigDecimal idempresa) throws EJBException {
    ResultSet rsSalida = null;
    String cQuery = "Select * from contablemonedas where idempresa = " + idempresa.toString();
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
        log.error("public List getMonedas() Error SQL: " + sqlException);
    } catch (Exception ex) {
        log.error("public List getMonedas() Salida por exception: " + ex);
    }
    return vecSalida;
}}

