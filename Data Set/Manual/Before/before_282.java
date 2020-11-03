public class Dummy{
public long addEmptyPatient() throws DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ps.executeUpdate("INSERT INTO patients(MID) VALUES(NULL)");
        return DBUtil.getLastInsert(conn);
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

