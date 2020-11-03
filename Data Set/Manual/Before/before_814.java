public class Dummy{
private List<ServerORK> getServerToMonitor() throws SQLException {
    List<ServerORK> serverList = new ArrayList<ServerORK>();
    Connection dbConnection = null;
    Statement statement = null;
    String selectTableSQL = "SELECT server_name, server_url, node, dt_last_check, dt_last_rfaction " + ", env from ORKIDS_SERVERS where active = 'T'";
    try {
        dbConnection = getDBConnection();
        statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        while (rs.next()) {
            String serverName = rs.getString("SERVER_NAME");
            String serverUrl = rs.getString("SERVER_URL");
            String node = rs.getString("NODE");
            Timestamp lastCheck = rs.getTimestamp("DT_LAST_CHECK");
            Timestamp lastRefresh = rs.getTimestamp("DT_LAST_RFACTION");
            String env = rs.getString("ENV");
            ServerORK serverOrk = addNewServer(getServerURL(serverName), getServerURL(serverUrl), node, lastCheck, lastRefresh, env);
            serverList.add(serverOrk);
            logger.info("Servers found " + serverList.size());
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        if (statement != null) {
            statement.close();
        }
        if (dbConnection != null) {
            dbConnection.close();
        }
    }
    return serverList;
}}

