public class Dummy{
public PatientBean getPatient(long mid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs = ps.executeQuery("SELECT * FROM patients WHERE MID = "+mid);
        PatientBean patient = rs.next() ? patientLoader.loadSingle(rs) : null;
        rs.close();
        return patient;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

