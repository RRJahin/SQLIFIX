public class Dummy{
public String getUserName(String userAccount) throws SQLException {
    Connection connection = DBConUnit.getInstance();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("select UserName from userdata where UserAccount=" + userAccount);
    Statement preparedStatement1 = connection.createStatement();
    ResultSet resultSet = preparedStatement1.executeQuery(stringBuilder1.toString());
    if (resultSet.next()) {
        String s = resultSet.getString(1);
        return s;
    } else
        return null;
}}

