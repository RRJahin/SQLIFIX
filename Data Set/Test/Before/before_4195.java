class Dummy{
public boolean hasEjercicioTablas(int idEjercicio) {
    boolean salida = false;
    try {
        Statement statement = dbconn.createStatement();
        String cQuery = "select count(*) as total from information_schema.tables where lower(table_name)='contableinfiplan" + idEjercicio + "'";
        log.info("query para hasEjercicioTablas :" + cQuery);
        ResultSet rsSalida = statement.executeQuery(cQuery);
        if (rsSalida != null && rsSalida.next()) {
            if (rsSalida.getInt(1) > 0)
                salida = true;
        }
    } catch (SQLException sqlException) {
        log.error("hasEjercicioTablas: Error SQL: " + sqlException);
    } catch (Exception ex) {
        log.error("hasEjercicioTablas Salida por exception: " + ex);
    }
    return salida;
}}

