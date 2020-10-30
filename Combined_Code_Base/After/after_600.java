class Dummy{
public boolean deleteInteraction(String firstDrug, String secondDrug) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM druginteractions WHERE (FirstDrug = ? OR SecondDrug = ?) AND (FirstDrug = ? OR SecondDrug = ?)")) {
        stmt.setObject(1, firstDrug);
        stmt.setObject(2, firstDrug);
        stmt.setObject(3, secondDrug);
        stmt.setObject(4, secondDrug);
        return stmt.executeUpdate() != 0;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

