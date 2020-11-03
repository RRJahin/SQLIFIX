public class Dummy{
private void updateResetFailuresToZero(final String ipAddr) throws DBException, SQLException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE resetpasswordfailures SET failureCount=0 WHERE IPAddress=?")) {
        stmt.setObject(1, ipAddr);
        stmt.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

