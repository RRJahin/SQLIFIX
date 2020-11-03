public class Dummy{
public void add(int userId, int musicId) throws SQLException {
    String sql = "insert into inception_preference ( userId, musicId ) values ("+userId+", "+musicId+");";
    Statement ps = conn.createStatement();
    ps.execute(sql);
}}

