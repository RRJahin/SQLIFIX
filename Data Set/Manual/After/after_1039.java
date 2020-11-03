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
        
        String query = "INSERT into user(name, username, password) values('?'," + "'?','?')";
        PreparedStatement stmt = dbConn.prepareStatement(query);
        stmt.setObject(1,name);
        stmt.setObject(2,uname);
        stmt.setObject(3,pwd);
        int records = stmt.executeUpdate();
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

