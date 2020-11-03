class Dummy{
public ResultSet getConnectionDS(Integer idDatasource, String qry) {
    Connection cn = null;
    ResultSet rs = null;
    try {
        Statement statement = dbconn.createStatement();
        ResultSet rsSalida = null;
        String cQuery = "Select * from datasources where iddatasource = " + idDatasource.toString();
        rsSalida = statement.executeQuery(cQuery);
        if (rsSalida != null && rsSalida.next()) {
            String _url = rsSalida.getString("url");
            String _driver = rsSalida.getString("driver");
            String _dbuser = rsSalida.getString("db_user");
            String _dbpass = rsSalida.getString("db_pass");
            log.info("resolviendo conexion: " + _url);
            Class.forName(_driver);
            cn = DriverManager.getConnection(_url, _dbuser, _dbpass);
            Statement st = cn.createStatement();
            rs = st.executeQuery(qry);
        }
    } catch (SQLException sqlException) {
        log.error("Error SQL: " + sqlException);
    } catch (Exception ex) {
        log.error("Salida por exception: " + ex);
    }
    return rs;
}}

