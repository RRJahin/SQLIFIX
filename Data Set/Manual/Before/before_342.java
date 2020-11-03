public class Dummy{
public long addEmptyPersonnel(final Role role) throws DBException, ITrustException {
    final long nextID = getNextID(role);
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        stmt.executeUpdate("INSERT INTO personnel(MID, Role) VALUES("+Long.valueOf(nextID).toString()+","+role.name()+")");
        return nextID;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

