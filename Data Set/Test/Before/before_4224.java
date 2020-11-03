class Dummy{
public String setQueryParametros(String query, Hashtable parametros) {
    String salida = query;
    String outString = "";
    try {
        Enumeration enume = parametros.keys();
        while (enume.hasMoreElements()) {
            String values = (String) enume.nextElement();
            String qry = "select * from parametros where upper(parametro) = '" + values.toUpperCase() + "'";
            Statement statement = dbconn.createStatement();
            ResultSet rsSalida = statement.executeQuery(qry);
            System.out.println("variable path" + path);
            if (rsSalida != null && rsSalida.next()) {
                int tipoParametro = rsSalida.getInt("idtipoparametro");
                String reemplazo = "";
                reemplazo = parametros.get(values).toString().trim();
                if (tipoParametro == 3 || tipoParametro == 4)
                    reemplazo = "'" + parametros.get(values).toString().trim() + "'";
                salida = salida.toUpperCase();
                String param = values.toUpperCase().trim();
                Pattern p = Pattern.compile(param);
                Matcher m = p.matcher(salida);
                outString = m.replaceAll(reemplazo);
                salida = outString;
            }
            if (rsSalida != null)
                rsSalida.close();
        }
    } catch (Exception ex) {
        log.error("Salida por exception setQueryParametros(String query, Hashtable parametros ): " + ex);
    }
    if (outString.equals(""))
        outString = query;
    log.info("query         : " + query);
    log.info("query depurado: " + outString);
    return outString;
}}

