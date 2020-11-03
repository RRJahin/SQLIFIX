public class Dummy{
public void resetPassword(final long mid, final String password) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE users SET password=?, salt=? WHERE MID=?")) {
        String salt = generateRandomSalt();
        String newPassword = DigestUtils.sha256Hex(password + salt);
        stmt.setObject(1, newPassword);
        stmt.setObject(2, salt);
        stmt.setObject(3, mid);
        stmt.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

