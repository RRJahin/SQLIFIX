class Dummy{
public long getTotalEntidad(String entidad, BigDecimal idempresa) throws EJBException {
    long total = 0l;
    ResultSet rsSalida = null;
    String cQuery = "SELECT count(1)AS total FROM " + entidad + "       WHERE idempresa = " + idempresa.toString();
    try {
        Statement statement = dbconn.createStatement();
        rsSalida = statement.executeQuery(cQuery);
        if (rsSalida.next()) {
            total = rsSalida.getLong("total");
        } else {
            log.warn("getTotalEntidad()- Error al recuperar total: " + entidad);
        }
    } catch (SQLException sqlException) {
        log.error("getTotalEntidad()- Error SQL: " + sqlException);
    } catch (Exception ex) {
        log.error("getTotalEntidad()- Salida por exception: " + ex);
    }
    return total;
}}

