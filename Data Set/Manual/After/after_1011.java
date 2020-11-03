public class Dummy{
public long addEmptyPersonnel(final Role role) throws DBException, ITrustException {
    final long nextID = getNextID(role);
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO personnel(MID, Role) VALUES(?,?)")) {
        stmt.setObject(1, Long.valueOf(nextID).toString());
        stmt.setObject(2, role.name());
        stmt.executeUpdate();
        return nextID;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

