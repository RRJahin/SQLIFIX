public class Dummy{
public long getNextID(final Role role) throws DBException, ITrustException {
    long minID = role.getMidFirstDigit() * 1000000000L;
    minID = minID == 0 ? 1 : minID;
    final long maxID = minID + 999999998L;
    long nextID = minID;
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT MAX(users.mid) FROM users WHERE mid BETWEEN ? AND ?")) {
        stmt.setObject(1, minID);
        stmt.setObject(2, maxID);
        final ResultSet results = stmt.executeQuery();
        if (results.next()) {
            nextID = results.getLong(1) + 1;
            if (nextID < minID) {
                nextID = minID;
            }
        }
        results.close();
        return nextID;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

