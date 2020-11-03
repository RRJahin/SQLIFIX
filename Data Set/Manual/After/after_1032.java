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
        
        String query = "SELECT * FROM user WHERE Login = '?' AND Password=" + "'?'";
        PreparedStatement stmt = dbConn.prepareStatement(query);
        stmt.setObject(1,uname);
        stmt.setObject(2,pwd);
        ResultSet rs = stmt.executeQuery();
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

