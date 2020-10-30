public class Dummy{
public void resetLoginFailuresToZero(final String ipAddr) throws DBException, SQLException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        stmt.executeUpdate("UPDATE loginfailures SET failureCount=0 WHERE IPAddress="+ipAddr);
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

