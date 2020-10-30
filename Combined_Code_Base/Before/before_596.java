class Dummy{
public List<AllergyBean> getAllergies(final long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        final ResultSet results = stmt.executeQuery("SELECT * FROM allergies WHERE PatientID="+pid+" ORDER BY FirstFound DESC");
        final List<AllergyBean> loadlist = allergyBeanLoader.loadList(results);
        return loadlist;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

