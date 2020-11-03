class Dummy{
public List<DrugInteractionBean> getInteractions(String drugCode) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery("SELECT * FROM druginteractions WHERE FirstDrug = "+drugCode+" OR SecondDrug = "+drugCode);
        List<DrugInteractionBean> loadlist = interactionLoader.loadList(rs);
        rs.close();
        return loadlist;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

