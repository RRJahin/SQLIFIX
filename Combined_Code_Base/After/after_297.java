public class Dummy{
public boolean checkIfPatientIsActive(long pid) throws ITrustException {
    if (pid == 0L)
        throw new DBException(new SQLException("PID cannot be 0"));
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM patients WHERE MID=? AND DateOfDeactivation IS NULL")) {
        ps.setObject(1, pid);
        ResultSet rs = ps.executeQuery();
        PatientBean bean = rs.next() ? patientLoader.loadSingle(rs) : new PatientBean();
        rs.close();
        return bean.getMID() == pid;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

