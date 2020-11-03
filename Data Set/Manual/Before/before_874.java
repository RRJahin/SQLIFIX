public class Dummy{
public boolean removeNDCode(MedicationBean med) throws DBException, ITrustException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        return stmt.executeUpdate("DELETE FROM ndcodes WHERE Code="+med.getNDCode()) == 1;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

