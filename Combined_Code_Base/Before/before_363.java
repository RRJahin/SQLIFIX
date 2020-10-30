public class Dummy{
public static boolean checkLogin(String uname, String pwd) throws Exception {
    boolean isUserAvailable = false;
    Connection dbConn = null;
    try {
        try {
            dbConn = DBConnection.createConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Statement stmt = dbConn.createStatement();
        String query = "SELECT * FROM user WHERE Login = '" + uname + "' AND Password=" + "'" + pwd + "'";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            isUserAvailable = true;
        }
    } catch (SQLException sqle) {
        throw sqle;
    } catch (Exception e) {
        if (dbConn != null) {
            dbConn.close();
        }
        throw e;
    } finally {
        if (dbConn != null) {
            dbConn.close();
        }
    }
    return isUserAvailable;
}}

