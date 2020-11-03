class Dummy{
public List getUsuario(long idUsuario) throws EJBException {
    ResultSet rsSalida = null;
    String cQuery = "SELECT idusuario, usuario, clave, administrador, email " + " FROM usuarios " + "WHERE idusuario = " + idUsuario;
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
        log.error("getUsuario()- Error SQL: " + sqlException);
    } catch (Exception ex) {
        log.error("getUsuario()- Salida por exception: " + ex);
    }
    return vecSalida;
}}

