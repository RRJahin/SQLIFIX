public class Dummy{
public boolean removeNDCode(MedicationBean med) throws DBException, ITrustException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM ndcodes WHERE Code=?")) {
        stmt.setObject(1, med.getNDCode());
        return stmt.executeUpdate() == 1;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

