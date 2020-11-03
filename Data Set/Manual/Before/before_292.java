public class Dummy{
public List<PatientBean> getDependents(long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs = ps.executeQuery("SELECT patients.* FROM representatives, patients, users " + "WHERE RepresenterMID="+pid+" AND RepresenteeMID=patients.MID AND users.MID=patients.MID AND users.isDependent=1");
        List<PatientBean> dependentsList = patientLoader.loadList(rs);
        rs.close();
        return dependentsList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

