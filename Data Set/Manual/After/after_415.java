public class Dummy{
public boolean has(int userId, int musicId) throws SQLException {
    String sql = "select * from inception_preference where userId = ? and musicId = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setObject(1, userId);
    ps.setObject(2, musicId);
    ResultSet rs = ps.executeQuery();
    return rs.next();
}}

