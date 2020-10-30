public class Dummy{
public List<PersonnelBean> getPersonnelFromHospital(final String hosid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM hcpassignedhos hah inner join personnel p where hah.hosID = ? and hah.HCPID = p.MID and p.role = 'hcp'")) {
        stmt.setObject(1, hosid);
        final ResultSet results = stmt.executeQuery();
        final List<PersonnelBean> personnelFromHospital = personnelLoader.loadList(results);
        results.close();
        return personnelFromHospital;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

