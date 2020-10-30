public class Dummy{
public PatientBean getPatient(long mid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM patients WHERE MID = ?")) {
        ps.setObject(1, mid);
        ResultSet rs = ps.executeQuery();
        PatientBean patient = rs.next() ? patientLoader.loadSingle(rs) : null;
        rs.close();
        return patient;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

