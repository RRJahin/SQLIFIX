public class Dummy{
public long addEmptyPatient() throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO patients(MID) VALUES(NULL)")) {
        ps.executeUpdate();
        return DBUtil.getLastInsert(conn);
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

