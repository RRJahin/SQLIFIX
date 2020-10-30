public class Dummy{
public String addUser(final Long mid, final Role role, final String password) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (MID, PASSWORD, SALT, ROLE, sQuestion, sAnswer) VALUES (?,?,?,?,?,?)")) {
        stmt.setObject(1, mid);
        String salt = generateRandomSalt();
        final String hashedPassword = DigestUtils.sha256Hex(password + salt);
        stmt.setObject(2, hashedPassword);
        stmt.setObject(3, salt);
        stmt.setObject(4, role.toString());
        stmt.setObject(5, "Enter the random password given in your account email");
        stmt.setObject(6, password);
        stmt.executeUpdate();
        return password;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

