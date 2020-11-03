class Dummy{
public boolean deleteInteraction(String firstDrug, String secondDrug) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        return stmt.executeUpdate("DELETE FROM druginteractions WHERE (FirstDrug = "+firstDrug+" OR SecondDrug = "+firstDrug+") AND (FirstDrug = "+secondDrug+" OR SecondDrug = "+secondDrug+")") != 0;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

