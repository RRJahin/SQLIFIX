public class Dummy{
public Map<String, String> fillMonitorConf() {
    Map<String, String> monitorConf = new Hashtable<String, String>();
    Connection dbConnection = null;
    PreparedStatement statement = null;
    String selectTableSQL = "select * from ORKIDS_VAR_CONFIG_VALUES where id_project = 1";
    try {
        dbConnection = getDBConnection();
        statement = dbConnection.prepareStatement(selectTableSQL);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String varName = rs.getString("VAR_NAME");
            String varValue = rs.getString("VAR_VALUE");
            monitorConf.put(varName, varValue);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        try {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    return monitorConf;
}}

