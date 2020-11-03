public class Dummy{
private void insertResetPasswordRow(final String ipAddr, final int failureCount) throws DBException, SQLException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO resetpasswordfailures(IPAddress, failureCount) VALUES(?,?)")) {
        stmt.setObject(1, ipAddr);
        stmt.setObject(2, failureCount);
        stmt.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

