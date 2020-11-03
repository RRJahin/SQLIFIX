public class Dummy{
private void insertResetPasswordRow(final String ipAddr, final int failureCount) throws DBException, SQLException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        stmt.executeUpdate("INSERT INTO resetpasswordfailures(IPAddress, failureCount) VALUES("+ipAddr+","+failureCount+")");
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

