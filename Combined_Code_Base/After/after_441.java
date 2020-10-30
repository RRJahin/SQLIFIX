public class Dummy{
public String getUidByUserAccount(String userAccount) throws SQLException {
    Connection connection = DBConUnit.getInstance();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("select UserUid from userrelative where UserAccount=?");
    PreparedStatement preparedStatement1 = connection.prepareStatement(stringBuilder1.toString());
    preparedStatement1.setObject(1,userAccount);
    ResultSet resultSet = preparedStatement1.executeQuery();
    if (resultSet.next()) {
        String s = resultSet.getString(1);
        return s;
    } else
        return null;
}}

