public class Dummy{
public void delete(int userId, int musicId) throws SQLException {
    String sql = "delete from inception_preference where userId = "+userId+" and musicId = "+musicId;
    Statement ps = conn.createStatement();
    ps.execute(sql);
}}

