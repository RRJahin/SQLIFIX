public class Dummy{
public boolean checkDeclaredHCP(long pid, long hcpid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        boolean patientHasDeclaredHCP = (ps.executeQuery("SELECT * FROM declaredhcp WHERE PatientID="+pid+" AND HCPID="+hcpid).next());
        return patientHasDeclaredHCP;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

