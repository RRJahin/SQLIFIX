public class Dummy{
public boolean loginCheck(String userAccount, String userPassword) throws SQLException {
    Connection connection = DBConUnit.getInstance();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("select UserAccount,UserPassword from userdata where UserAccount=" + userAccount + " and UserPassword=" + userPassword);
    Statement preparedStatement1 = connection.createStatement();
    ResultSet resultSet = preparedStatement1.executeQuery(stringBuilder1.toString());
    if (resultSet.next())
        return true;
    else
        return false;
}}

