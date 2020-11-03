public class Dummy{
public boolean toCheckEmailUser(ForgotPassword forgotObj) {
    PreparedStatement preStat = null;
    boolean isValidUser = false;
    String sqlQuery = "Select * from User where email=? and userName=? ";
    try {
        preStat = connection.prepareStatement(sqlQuery);
        preStat.setObject(2, forgotObj.getUserName());
        preStat.setObject(1, forgotObj.getEmail());
        ResultSet resultSet = preStat.executeQuery();
        if (resultSet.next()) {
            return isValidUser = true;
        } else
            return isValidUser;
    } catch (SQLException e) {
        return isValidUser;
    }
}}

