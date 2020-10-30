public class Dummy{
public String getSecurityQuestion(final long mid) throws ITrustException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT sQuestion FROM users WHERE MID=?")) {
        stmt.setObject(1, mid);
        final ResultSet results = stmt.executeQuery();
        if (results.next()) {
            final String result = results.getString("sQuestion");
            results.close();
            return result;
        } else {
            results.close();
            throw new ITrustException("No security question set for MID: " + mid);
        }
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

