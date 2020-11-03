class Dummy{
public Object get(String login, String password) throws SQLException, ClassNotFoundException {
    Connection connection = ConnectionManager.getConnection();
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery("SELECT Id,firstname,lastname FROM Utilisateurs WHERE login='" + login + "' AND pass='" + password + "'");
    User user = null;
    while (result.next()) {
        user = new User();
        user.setIdentifier(result.getInt("Id"));
        user.setFirstName(result.getString("firstname"));
        user.setLastName(result.getString("lastname"));
        user.setLogin(login);
        user.setPassword(password);
        break;
    }
    return user;
}}

