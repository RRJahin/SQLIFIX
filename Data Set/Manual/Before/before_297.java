public class Dummy{
public boolean checkIfPatientIsActive(long pid) throws ITrustException {
    if (pid == 0L)
        throw new DBException(new SQLException("PID cannot be 0"));
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs = ps.executeQuery("SELECT * FROM patients WHERE MID="+pid+" AND DateOfDeactivation IS NULL");
        PatientBean bean = rs.next() ? patientLoader.loadSingle(rs) : new PatientBean();
        rs.close();
        return bean.getMID() == pid;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

