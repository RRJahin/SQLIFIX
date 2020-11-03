public class Dummy{
public MedicationBean getNDCode(String code) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery("SELECT * FROM ndcodes WHERE Code = "+code);
        MedicationBean result = rs.next() ? medicationLoader.loadSingle(rs) : null;
        rs.close();
        return result;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

