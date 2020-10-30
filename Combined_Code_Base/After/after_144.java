public class Dummy{
public void editPassword(int userId, PasswordBean passwordBean) {
    String sql = "UPDATE users " + "SET password = ?, change_user_name = javauser, change_date = ?" + "WHERE id = ?";
    PreparedStatement pstat = null;
    try {
        pstat = CONN.prepareStatement(sql);
        pstat.setObject(1, passwordBean.getPassword1());
        pstat.setObject(2, GenericUtilities.getCurrentTimeStamp());
        pstat.setObject(3, userId);
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

