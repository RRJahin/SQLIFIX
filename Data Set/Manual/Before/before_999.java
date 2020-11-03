public class Dummy{
public String addUser(final Long mid, final Role role, final String password) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        String salt = generateRandomSalt();
        final String hashedPassword = DigestUtils.sha256Hex(password + salt);
        stmt.executeUpdate("INSERT INTO users (MID, PASSWORD, SALT, ROLE, sQuestion, sAnswer) VALUES ("+mid+","+hashedPassword+","+salt+","+role.toString()+","+"Enter the random password given in your account email"+","+password+")");
        return password;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

