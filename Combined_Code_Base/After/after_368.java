public class Dummy{
public boolean isDependent(final long mid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE MID=? AND isDependent=1")) {
        stmt.setObject(1, mid);
        final ResultSet results = stmt.executeQuery();
        final boolean check = results.next();
        results.close();
        return check;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

