public class Dummy{
public String getUidByUserAccount(String userAccount) throws SQLException {
    Connection connection = DBConUnit.getInstance();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("select UserUid from userrelative where UserAccount=" + userAccount);
    Statement preparedStatement1 = connection.createStatement();
    ResultSet resultSet = preparedStatement1.executeQuery(stringBuilder1.toString());
    if (resultSet.next()) {
        String s = resultSet.getString(1);
        return s;
    } else
        return null;
}}

