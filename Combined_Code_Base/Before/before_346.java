public class Dummy{
public List<HospitalBean> getUAPHospitals(final long mid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final ResultSet results = stmt.executeQuery("SELECT DISTINCT hospitals.* FROM hcpassignedhos hah " + "INNER JOIN hcprelations ON hah.HCPID = hcprelations.HCP " + "INNER JOIN hospitals ON hah.hosID = hospitals.HospitalID " + "WHERE hcprelations.UAP="+mid+" ORDER BY HospitalName ASC");
        final List<HospitalBean> hospitals = hospBeanLoader.loadList(results);
        results.close();
        return hospitals;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

