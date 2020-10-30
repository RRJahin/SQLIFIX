public class Dummy{
public void setDependent(long mid, boolean dependency) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE users SET isDependent=? WHERE MID=?")) {
        stmt.setBoolean(1, dependency);
        stmt.setObject(2, mid);
        stmt.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

