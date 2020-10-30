public class Dummy{
public boolean declareHCP(long pid, long hcpID) throws DBException, ITrustException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO declaredhcp(PatientID, HCPID) VALUES(?,?)")) {
        ps.setObject(1, pid);
        ps.setObject(2, hcpID);
        boolean successfullyAdded = ps.executeUpdate() == 1;
        return successfullyAdded;
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062) {
            throw new ITrustException("HCP " + hcpID + " has already been declared for patient " + pid);
        } else {
            throw new DBException(e);
        }
    }
}}

