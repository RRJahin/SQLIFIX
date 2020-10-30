public class Dummy{
public boolean isUser(Login login) {
    PreparedStatement preStat = null;
    boolean isValidUser = false;
    String sqlQuery = "Select * from User where userName=? and password=?";
    try {
        preStat = connection.prepareStatement(sqlQuery);
        preStat.setObject(1, login.getUserName());
        preStat.setObject(2, login.getPassword());
        ResultSet resultSet = preStat.executeQuery();
        if (resultSet.next()) {
            return isValidUser = true;
        } else
            return isValidUser;
    } catch (SQLException e) {
        return isValidUser;
    }
}}

