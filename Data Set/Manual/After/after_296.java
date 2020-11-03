public class Dummy{
public boolean checkIfRepresenteeIsActive(long representee) throws DBException {
    if (representee == 0L) {
        throw new DBException(new SQLException("PID cannot be 0"));
    }
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM patients WHERE MID=? AND DateOfDeactivation IS NULL")) {
        ps.setObject(1, representee);
        ResultSet rs = ps.executeQuery();
        PatientBean bean = new PatientBean();
        if (rs.next())
            bean = patientLoader.loadSingle(rs);
        rs.close();
        return bean.getMID() == representee;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

