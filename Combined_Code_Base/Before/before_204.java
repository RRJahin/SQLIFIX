public class Dummy{
public int updateCode(MedicationBean med) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        return stmt.executeUpdate("UPDATE ndcodes SET Description = "+ med.getDescription() + "WHERE Code = "+med.getNDCode());
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

