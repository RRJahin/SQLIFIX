public class Dummy{
public boolean authenticatePassword(final long mid, final String password) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("Select * FROM users WHERE MID=? AND password=?")) {
        String salt = getSalt(mid);
        stmt.setObject(1, mid);
        stmt.setObject(2, DigestUtils.sha256Hex(password + salt));
        final ResultSet results = stmt.executeQuery();
        final boolean check = results.next();
        results.close();
        return check;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

