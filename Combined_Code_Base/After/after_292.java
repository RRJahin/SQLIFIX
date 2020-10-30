public class Dummy{
public List<PatientBean> getDependents(long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT patients.* FROM representatives, patients, users " + "WHERE RepresenterMID=? AND RepresenteeMID=patients.MID AND users.MID=patients.MID AND users.isDependent=1")) {
        ps.setObject(1, pid);
        ResultSet rs = ps.executeQuery();
        List<PatientBean> dependentsList = patientLoader.loadList(rs);
        rs.close();
        return dependentsList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

