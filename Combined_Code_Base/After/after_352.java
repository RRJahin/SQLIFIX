public class Dummy{
public void recordLoginFailure(final String ipAddr) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE loginfailures SET FailureCount=FailureCount+1, lastFailure=CURRENT_TIMESTAMP WHERE IPAddress=?")) {
        stmt.setObject(1, ipAddr);
        final int numUpdated = stmt.executeUpdate();
        if (numUpdated == 0) {
            insertLoginFailureRow(ipAddr, 1);
        }
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

