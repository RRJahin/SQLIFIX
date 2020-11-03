public class Dummy{
public int getLoginFailures(final String ipAddr) throws DBException {
    int numFailures;
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final ResultSet results = stmt.executeQuery("SELECT * FROM loginfailures WHERE IPADDRESS="+ipAddr);
        if (results.next()) {
            if (System.currentTimeMillis() - results.getTimestamp("lastFailure").getTime() > LOGIN_TIMEOUT) {
                updateFailuresToZero(ipAddr);
                results.close();
                numFailures = 0;
            } else {
                final int result = results.getInt("failureCount");
                results.close();
                numFailures = result;
            }
        } else {
            insertLoginFailureRow(ipAddr, 0);
            results.close();
            numFailures = 0;
        }
    } catch (SQLException e) {
        throw new DBException(e);
    }
    return numFailures;
}}

