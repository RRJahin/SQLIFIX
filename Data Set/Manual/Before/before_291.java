public class Dummy{
public List<PatientBean> getRepresented(long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs = ps.executeQuery("SELECT patients.* FROM representatives, patients " + "WHERE RepresenterMID="+pid+" AND RepresenteeMID=patients.MID");
        List<PatientBean> loadlist = patientLoader.loadList(rs);
        rs.close();
        return loadlist;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

