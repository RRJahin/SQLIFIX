public class Dummy{
public void setDependent(long mid, boolean dependency) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        stmt.executeUpdate("UPDATE users SET isDependent="+dependency+" WHERE MID="+mid);
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

