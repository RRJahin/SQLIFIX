public class Dummy{
public List<HospitalBean> getHospitals(final long mid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final ResultSet results = stmt.executeQuery("SELECT * FROM hcpassignedhos hah,hospitals h " + "WHERE hah.HCPID="+mid+" AND hah.HosID=h.HospitalID ORDER BY HospitalName ASC");
        final List<HospitalBean> hospitals = hospBeanLoader.loadList(results);
        results.close();
        return hospitals;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

