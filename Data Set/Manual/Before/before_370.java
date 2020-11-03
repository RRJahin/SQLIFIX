public class Dummy{
public static boolean insertUser(String name, String uname, String pwd) throws SQLException, Exception {
    boolean insertStatus = false;
    Connection dbConn = null;
    try {
        try {
            dbConn = DBConnection.createConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Statement stmt = dbConn.createStatement();
        String query = "INSERT into user(name, username, password) values('" + name + "'," + "'" + uname + "','" + pwd + "')";
        int records = stmt.executeUpdate(query);
        if (records > 0) {
            insertStatus = true;
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
    return insertStatus;
}}

