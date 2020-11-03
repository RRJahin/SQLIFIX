public class Dummy{
private void insertLoginFailureRow(final String ipAddr, int failureCount) throws DBException, SQLException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO loginfailures(IPAddress, failureCount) VALUES(?,?)")) {
        stmt.setObject(1, ipAddr);
        stmt.setObject(2, failureCount);
        stmt.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

