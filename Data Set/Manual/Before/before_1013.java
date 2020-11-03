public class Dummy{
public boolean checkPersonnelExists(final long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final ResultSet results = stmt.executeQuery("SELECT * FROM personnel WHERE MID="+pid);
        final boolean exists = results.next();
        results.close();
        return exists;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

