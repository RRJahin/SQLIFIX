public class Dummy{
public int updateCode(MedicationBean med) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE ndcodes SET Description = ? " + "WHERE Code = ?")) {
        stmt.setObject(1, med.getDescription());
        stmt.setObject(2, med.getNDCode());
        return stmt.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

