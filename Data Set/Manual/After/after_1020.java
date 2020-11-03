public class Dummy{
public List<PersonnelBean> getUAPsForHCP(final long hcpid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM personnel WHERE MID IN (SELECT UAP FROM hcprelations WHERE HCP=?)")) {
        stmt.setObject(1, hcpid);
        final ResultSet results = stmt.executeQuery();
        final List<PersonnelBean> uaps = personnelLoader.loadList(results);
        results.close();
        return uaps;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

