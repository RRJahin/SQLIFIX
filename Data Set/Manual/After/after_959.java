public class Dummy{
public boolean checkDeclaredHCP(long pid, long hcpid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM declaredhcp WHERE PatientID=? AND HCPID=?")) {
        ps.setObject(1, pid);
        ps.setObject(2, hcpid);
        boolean patientHasDeclaredHCP = (ps.executeQuery().next());
        return patientHasDeclaredHCP;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

