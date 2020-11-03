public class Dummy{
public boolean has(int userId, int musicId) throws SQLException {
    String sql = "select * from inception_preference where userId = "+userId+" and musicId = "+musicId;
    Statement ps = conn.createStatement();
    ResultSet rs = ps.executeQuery(sql);
    return rs.next();
}}

