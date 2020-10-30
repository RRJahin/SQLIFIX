public class Dummy{
public List<PatientBean> getRepresenting(long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT patients.* FROM representatives, patients " + "WHERE RepresenteeMID=? AND RepresenterMID=patients.MID")) {
        ps.setObject(1, pid);
        ResultSet rs = ps.executeQuery();
        List<PatientBean> representingList = patientLoader.loadList(rs);
        rs.close();
        return representingList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

