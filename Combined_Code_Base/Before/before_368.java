public class Dummy{
public boolean isDependent(final long mid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final ResultSet results = stmt.executeQuery("SELECT * FROM users WHERE MID="+mid+" AND isDependent=1");
        final boolean check = results.next();
        results.close();
        return check;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

