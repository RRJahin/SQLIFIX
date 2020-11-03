public class Dummy{
public List<PersonnelBean> getUAPsForHCP(final long hcpid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final ResultSet results = stmt.executeQuery("SELECT * FROM personnel WHERE MID IN (SELECT UAP FROM hcprelations WHERE HCP="+hcpid+")");
        final List<PersonnelBean> uaps = personnelLoader.loadList(results);
        results.close();
        return uaps;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

