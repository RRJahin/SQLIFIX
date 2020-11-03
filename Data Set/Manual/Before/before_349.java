public class Dummy{
public List<PersonnelBean> getPersonnelFromHospital(final String hosid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final ResultSet results = stmt.executeQuery("SELECT * FROM hcpassignedhos hah inner join personnel p where hah.hosID = "+hosid+" and hah.HCPID = p.MID and p.role = 'hcp'");
        final List<PersonnelBean> personnelFromHospital = personnelLoader.loadList(results);
        results.close();
        return personnelFromHospital;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

