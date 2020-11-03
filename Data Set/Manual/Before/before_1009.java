public class Dummy{
public String getName(final long mid) throws ITrustException, DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        ResultSet results = stmt.executeQuery("SELECT firstName, lastName FROM personnel WHERE MID="+mid);
        if (!results.next()) {
            throw new ITrustException("User does not exist");
        }
        final String result = results.getString("firstName") + " " + results.getString("lastName");
        results.close();
        return result;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

