public class Dummy{
public List<PatientBean> getRepresenting(long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs = ps.executeQuery("SELECT patients.* FROM representatives, patients " + "WHERE RepresenteeMID="+pid+" AND RepresenterMID=patients.MID");
        List<PatientBean> representingList = patientLoader.loadList(rs);
        rs.close();
        return representingList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

