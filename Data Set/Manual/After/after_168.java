public class Dummy{
public void updateLrc(int id, String lrc) throws SQLException {
    String sql = "update inception_music set lyrics = ? where id = ?";
    PreparedStatement ps = util.getConnection().prepareStatement(sql);
    ps.setObject(1, lrc);
    ps.setObject(2, id);
    ps.execute();
}}

