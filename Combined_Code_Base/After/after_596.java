class Dummy{
public List<AllergyBean> getAllergies(final long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM allergies WHERE PatientID=? ORDER BY FirstFound DESC")) {
        stmt.setObject(1, pid);
        final ResultSet results = stmt.executeQuery();
        final List<AllergyBean> loadlist = allergyBeanLoader.loadList(results);
        return loadlist;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

