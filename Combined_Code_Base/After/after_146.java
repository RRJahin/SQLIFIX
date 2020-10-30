public class Dummy{
public List<String> getInternetAddress(String mode) {
    List<String> serverList = new ArrayList<String>();
    Connection dbConnection = null;
    PreparedStatement statement = null;
    String selectTableSQL = "SELECT NOTIFICATION_NAME, NOTIFICATION_EMAIL from ORKIDS_EMAIL_NOTIFICATION WHERE NOTIFICATION_TYPE = 'T'";
    try {
        dbConnection = getDBConnection();
        statement = dbConnection.prepareStatement(selectTableSQL);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String email = rs.getString("NOTIFICATION_EMAIL");
            String notificationName = rs.getString("NOTIFICATION_NAME");
            if (getServerURL(mode).equals("test")) {
                if (notificationName.toLowerCase().contains("oscar")) {
                    serverList.add(email);
                }
            } else {
                serverList.add(email);
            }
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
    return serverList;
}}

