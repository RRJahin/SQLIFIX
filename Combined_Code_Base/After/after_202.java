public class Dummy{
public MedicationBean getNDCode(String code) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ndcodes WHERE Code = ?")) {
        stmt.setObject(1, code);
        ResultSet rs = stmt.executeQuery();
        MedicationBean result = rs.next() ? medicationLoader.loadSingle(rs) : null;
        rs.close();
        return result;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

