public class Dummy{
public List<HospitalBean> getUAPHospitals(final long mid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT hospitals.* FROM hcpassignedhos hah " + "INNER JOIN hcprelations ON hah.HCPID = hcprelations.HCP " + "INNER JOIN hospitals ON hah.hosID = hospitals.HospitalID " + "WHERE hcprelations.UAP=? ORDER BY HospitalName ASC")) {
        stmt.setObject(1, mid);
        final ResultSet results = stmt.executeQuery();
        final List<HospitalBean> hospitals = hospBeanLoader.loadList(results);
        results.close();
        return hospitals;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

