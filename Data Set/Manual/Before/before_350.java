public class Dummy{
public List<PersonnelBean> getAllPersonnel() throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final ResultSet results = stmt.executeQuery("SELECT * FROM personnel where role in ('hcp','uap','er') ");
        final List<PersonnelBean> allPersonnel = personnelLoader.loadList(results);
        results.close();
        return allPersonnel;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

