public class Dummy{
public boolean checkIfRepresenteeIsActive(long representee) throws DBException {
    if (representee == 0L) {
        throw new DBException(new SQLException("PID cannot be 0"));
    }
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs = ps.executeQuery("SELECT * FROM patients WHERE MID="+representee+" AND DateOfDeactivation IS NULL");
        PatientBean bean = new PatientBean();
        if (rs.next())
            bean = patientLoader.loadSingle(rs);
        rs.close();
        return bean.getMID() == representee;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

