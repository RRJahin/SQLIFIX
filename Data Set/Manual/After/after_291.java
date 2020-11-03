public class Dummy{
public List<PatientBean> getRepresented(long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT patients.* FROM representatives, patients " + "WHERE RepresenterMID=? AND RepresenteeMID=patients.MID")) {
        ps.setObject(1, pid);
        ResultSet rs = ps.executeQuery();
        List<PatientBean> loadlist = patientLoader.loadList(rs);
        rs.close();
        return loadlist;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

