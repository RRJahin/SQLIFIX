public class Dummy{
public void updateMusicImage(Music m) throws SQLException {
    String sql = "update inception_music set imageUrl = ? where id = ?";
    PreparedStatement ps = util.getConnection().prepareStatement(sql);
    ps.setObject(1, m.getImageUrl());
    ps.setObject(2, m.getId());
    ps.execute();
}}

