public class Dummy{
public void updateMusicImage(Music m) throws SQLException {
    String sql = "update inception_music set imageUrl = "+m.getImageUrl()+" where id = "+m.getId();
    Statement ps = util.getConnection().createStatement();
    ps.executeQuery(sql);
}}

