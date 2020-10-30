public class Dummy{
public void add(int userId, int musicId) throws SQLException {
    String sql = "insert into inception_preference ( userId, musicId ) values (?, ?);";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setObject(1, userId);
    ps.setObject(2, musicId);
    ps.execute();
}}

