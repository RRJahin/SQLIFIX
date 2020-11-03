public class Dummy{
public void addUserInfo(User userInfo) {
    PreparedStatement preStat = null;
    String sqlQuery = "Insert into User(id,firstName,lastName,userName,email,password,mobileNo) values(?,?,?,?,?,?,?)";
    try {
        preStat = connection.prepareStatement(sqlQuery);
        preStat.setObject(1, userInfo.getId());
        preStat.setObject(2, userInfo.getFirstName());
        preStat.setObject(3, userInfo.getLastName());
        preStat.setObject(4, userInfo.getUserName());
        preStat.setObject(5, userInfo.getEmail());
        preStat.setObject(6, userInfo.getPassword());
        preStat.setObject(7, userInfo.getMobileNo());
        preStat.executeUpdate();
        System.out.println("your data is sucessfully added....!!!!!");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}}

