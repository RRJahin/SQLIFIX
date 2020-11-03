public class Dummy{
public Role getUserRole(final long mid) throws ITrustException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT role FROM users WHERE MID=?")) {
        stmt.setObject(1, mid);
        final ResultSet results;
        results = stmt.executeQuery();
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

