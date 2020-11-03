public class Dummy{
public String getSecurityAnswer(final long mid) throws ITrustException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT sAnswer FROM users WHERE MID=?")) {
        stmt.setObject(1, mid);
        final ResultSet results = stmt.executeQuery();
        if (results.next()) {
            final String result = results.getString("sAnswer");
            results.close();
            return result;
        } else {
            results.close();
            throw new ITrustException("No security answer set for MID " + mid);
        }
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

