public class Dummy{
public boolean loginCheck(String userAccount, String userPassword) throws SQLException {
    Connection connection = DBConUnit.getInstance();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("select UserAccount,UserPassword from userdata where UserAccount=? and UserPassword=?");
    PreparedStatement preparedStatement1 = connection.prepareStatement(stringBuilder1.toString());
    preparedStatement1.setObjcet(1,userAccount);
    preparedStatement1.setObject(2,userPassword);
    ResultSet resultSet = preparedStatement1.executeQuery();
    if (resultSet.next())
        return true;
    else
        return false;
}}

