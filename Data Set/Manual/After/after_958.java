public class Dummy{
public boolean undeclareHCP(long pid, long hcpID) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM declaredhcp WHERE PatientID=? AND HCPID=?")) {
        ps.setObject(1, pid);
        ps.setObject(2, hcpID);
        boolean successfullyDeleted = ps.executeUpdate() == 1;
        return successfullyDeleted;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

