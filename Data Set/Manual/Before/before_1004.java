public class Dummy{
public Role getUserRole(final long mid) throws ITrustException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final ResultSet results;
        results = stmt.executeQuery("SELECT role FROM users WHERE MID="+mid);
        if (results.next()) {
            final Role result = Role.parse(results.getString("role"));
            results.close();
            return result;
        } else {
            throw new ITrustException("User does not exist");
        }
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

