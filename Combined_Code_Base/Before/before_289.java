public class Dummy{
public boolean undeclareHCP(long pid, long hcpID) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        boolean successfullyDeleted = ps.executeUpdate("DELETE FROM declaredhcp WHERE PatientID="+pid+" AND HCPID="+hcpID) == 1;
        return successfullyDeleted;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

