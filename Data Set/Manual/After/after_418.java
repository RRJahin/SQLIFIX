public class Dummy{
public void delete(int userId, int musicId) throws SQLException {
    String sql = "delete from inception_preference where userId = ? and musicId = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setObject(1, userId);
    ps.setObject(2, musicId);
    ps.execute();
}}

