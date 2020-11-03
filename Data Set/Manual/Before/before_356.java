public class Dummy{
private void insertLoginFailureRow(final String ipAddr, int failureCount) throws DBException, SQLException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        stmt.executeUpdate("INSERT INTO loginfailures(IPAddress, failureCount) VALUES("+ipAddr+","+failureCount+")");
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

