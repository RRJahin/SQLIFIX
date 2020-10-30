public class Dummy{
public boolean declareHCP(long pid, long hcpID) throws DBException, ITrustException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        boolean successfullyAdded = ps.executeUpdate("INSERT INTO declaredhcp(PatientID, HCPID) VALUES("+pid+","+hcpID+")") == 1;
        return successfullyAdded;
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062) {
            throw new ITrustException("HCP " + hcpID + " has already been declared for patient " + pid);
        } else {
            throw new DBException(e);
        }
    }
}}

