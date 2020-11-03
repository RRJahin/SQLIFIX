public class Dummy{
private void updateFailuresToZero(final String ipAddr) throws DBException, SQLException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE loginfailures SET failureCount=0 WHERE IPAddress=?")) {
        stmt.setObject(1, ipAddr);
        stmt.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

