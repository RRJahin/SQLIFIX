public class Dummy{
public void recordResetPasswordFailure(final String ipAddr) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final int numUpdated = stmt.executeUpdate("UPDATE resetpasswordfailures SET failurecount=failurecount+1 WHERE ipaddress="+ipAddr);
        if (numUpdated == 0) {
            insertResetPasswordRow(ipAddr, 1);
        }
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}
