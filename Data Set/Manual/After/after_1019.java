public class Dummy{
public List<PersonnelBean> getAllPersonnel() throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM personnel where role in ('hcp','uap','er') ")) {
        final ResultSet results = stmt.executeQuery();
        final List<PersonnelBean> allPersonnel = personnelLoader.loadList(results);
        results.close();
        return allPersonnel;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

