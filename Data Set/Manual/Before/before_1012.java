public class Dummy{
public PersonnelBean getPersonnel(final long mid) throws DBException {
    PersonnelBean bean = null;
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final ResultSet results = stmt.executeQuery("SELECT * FROM personnel WHERE MID = "+mid);
        if (results.next()) {
            bean = personnelLoader.loadSingle(results);
        }
        results.close();
    } catch (SQLException e) {
        throw new DBException(e);
    }
    return bean;
}}

