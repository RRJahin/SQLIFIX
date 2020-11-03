public class Dummy{
public void updateLrc(int id, String lrc) throws SQLException {
    String sql = "update inception_music set lyrics = "+lrc+" where id = "+id;
    Statement ps = util.getConnection().createStatement();
    ps.executeQuery(sql);
}}

