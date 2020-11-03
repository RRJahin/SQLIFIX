public class Dummy{
public void updatePassword(ForgotPassword forgotObj) {
    PreparedStatement preStat = null;
    String sqlQuery = "UPDATE User SET password=? where userName=? and email=?";
    try {
        preStat = connection.prepareStatement(sqlQuery);
        preStat.setObject(1, forgotObj.getPassword());
        preStat.setObject(2, forgotObj.getUserName());
        preStat.setObject(3, forgotObj.getEmail());
        preStat.executeUpdate();
        System.out.println("your data is updated sucessfully....!!!!!");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}}

