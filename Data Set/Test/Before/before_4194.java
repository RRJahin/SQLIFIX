class Dummy{
public boolean existeTabla(String tabla) {
    boolean salida = false;
    try {
        Statement statement = dbconn.createStatement();
        String cQuery = "select count(*) as total from information_schema.tables where lower(table_name)='" + tabla + "'";
        ResultSet rsSalida = statement.executeQuery(cQuery);
        if (rsSalida != null && rsSalida.next()) {
            if (rsSalida.getInt(1) > 0)
                salida = true;
        }
    } catch (SQLException sqlException) {
        log.error("existeTabla(String tabla): Error SQL: " + sqlException);
    } catch (Exception ex) {
        log.error("existeTabla(String tabla) Salida por exception: " + ex);
    }
    return salida;
}}

