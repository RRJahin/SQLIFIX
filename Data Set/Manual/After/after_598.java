class Dummy{
public List<DrugInteractionBean> getInteractions(String drugCode) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM druginteractions WHERE FirstDrug = ? OR SecondDrug = ?")) {
        stmt.setObject(1, drugCode);
        stmt.setObject(2, drugCode);
        ResultSet rs = stmt.executeQuery();
        List<DrugInteractionBean> loadlist = interactionLoader.loadList(rs);
        rs.close();
        return loadlist;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

