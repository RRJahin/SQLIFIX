public class Dummy{
public void recordResetPasswordFailure(final String ipAddr) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE resetpasswordfailures SET failurecount=failurecount+1 WHERE ipaddress=?")) {
        stmt.setObject(1, ipAddr);
        final int numUpdated = stmt.executeUpdate();
        if (numUpdated == 0) {
            insertResetPasswordRow(ipAddr, 1);
        }
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

