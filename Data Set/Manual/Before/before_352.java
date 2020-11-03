public class Dummy{
public void recordLoginFailure(final String ipAddr) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final int numUpdated = stmt.executeUpdate("UPDATE loginfailures SET FailureCount=FailureCount+1, lastFailure=CURRENT_TIMESTAMP WHERE IPAddress="+ipAddr);
        if (numUpdated == 0) {
            insertLoginFailureRow(ipAddr, 1);
        }
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

