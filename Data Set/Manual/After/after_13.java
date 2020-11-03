public class Dummy{
public boolean checkUserName(String userName) {
    PreparedStatement preStat = null;
    boolean isValidUser = false;
    String sqlQuery = "Select * from User where userName=? ";
    try {
        preStat = connection.prepareStatement(sqlQuery);
        preStat.setObject(1, userName);
        ResultSet resultSet = preStat.executeQuery();
        if (resultSet.next()) {
            return isValidUser = true;
        } else
            return isValidUser;
    } catch (SQLException e) {
        return isValidUser;
    }
}}

