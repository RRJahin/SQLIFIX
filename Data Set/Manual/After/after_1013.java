public class Dummy{
public boolean checkPersonnelExists(final long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM personnel WHERE MID=?")) {
        stmt.setObject(1, pid);
        final ResultSet results = stmt.executeQuery();
        final boolean exists = results.next();
        results.close();
        return exists;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

