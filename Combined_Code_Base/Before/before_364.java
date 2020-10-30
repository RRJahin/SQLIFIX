public class Dummy{
public boolean authenticatePassword(final long mid, final String password) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        String salt = getSalt(mid);
        final ResultSet results = stmt.executeQuery("Select * FROM users WHERE MID="+mid+" AND password="+DigestUtils.sha256Hex(password + salt));
        final boolean check = results.next();
        results.close();
        return check;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

