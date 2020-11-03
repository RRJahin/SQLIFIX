public class Dummy{
public void resetPassword(final long mid, final String password) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        String salt = generateRandomSalt();
        String newPassword = DigestUtils.sha256Hex(password + salt);
        stmt.executeUpdate("UPDATE users SET password="+newPassword+", salt="+salt+" WHERE MID="+mid);
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

