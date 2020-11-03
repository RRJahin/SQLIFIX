public class Dummy{
public void deleteService(int serviceId) {
    String sql = "UPDATE service_order " + "SET expiration_date = ?, change_user_name = javauser, change_date = ?" + "WHERE id = ?";
    PreparedStatement pstat = null;
    try {
        pstat = CONN.prepareStatement(sql);
        pstat.setObject(1, new java.sql.Date(new java.util.Date().getTime()));
        pstat.setObject(2, GenericUtilities.getCurrentTimeStamp());
        pstat.setObject(3, serviceId);
        pstat.executeUpdate();
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

