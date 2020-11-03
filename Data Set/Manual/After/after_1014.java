public class Dummy{
public List<HospitalBean> getHospitals(final long mid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM hcpassignedhos hah,hospitals h " + "WHERE hah.HCPID=? AND hah.HosID=h.HospitalID ORDER BY HospitalName ASC")) {
        stmt.setObject(1, mid);
        final ResultSet results = stmt.executeQuery();
        final List<HospitalBean> hospitals = hospBeanLoader.loadList(results);
        results.close();
        return hospitals;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

