public class Dummy{
public void editPassword(int userId, PasswordBean passwordBean) {
    String sql = "UPDATE users " + "SET password = "+passwordBean.getPassword1()+", change_user_name = javauser, change_date = "+GenericUtilities.getCurrentTimeStamp() + "WHERE id = "+userId;
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

