public class Dummy{
public void deleteService(int serviceId) {
    String sql = "UPDATE service_order " + "SET expiration_date = "+new java.sql.Date(new java.util.Date().getTime())+", change_user_name = javauser, change_date = "+GenericUtilities.getCurrentTimeStamp() + "WHERE id = "+serviceId;
    Statement pstat = null;
    try {
        pstat = CONN.createStatement();
        pstat.executeUpdate(sql);
        lastError = null;
    } catch (SQLException sqle) {
        lastError = sqle.getMessage();
    } finally {
        if (pstat != null) {
            try {
                pstat.close();
            } catch (SQLException sqle) {
            }
        }
    }
}}

