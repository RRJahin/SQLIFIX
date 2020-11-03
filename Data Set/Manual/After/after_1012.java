public class Dummy{
public PersonnelBean getPersonnel(final long mid) throws DBException {
    PersonnelBean bean = null;
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM personnel WHERE MID = ?")) {
        stmt.setObject(1, mid);
        final ResultSet results = stmt.executeQuery();
        if (results.next()) {
            bean = personnelLoader.loadSingle(results);
        }
        results.close();
    } catch (SQLException e) {
        throw new DBException(e);
    }
    return bean;
}}

