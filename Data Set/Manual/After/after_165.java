public class Dummy{
public void updateBaiscInfo(Music music) throws SQLException {
    String sql = "update inception_music set musicName = ?, musicStyle = ?," + " musicLanguage = ?, artistName = ?, albumName = ? where id = ?";
    PreparedStatement ps = util.getConnection().prepareStatement(sql);
    ps.setObject(1, music.getMusicName());
    ps.setObject(2, music.getMusicStyle());
    ps.setObject(3, music.getMusicLanguage());
    ps.setObject(4, music.getArtistName());
    ps.setObject(5, music.getAlbumName());
    ps.setObject(6, music.getId());
    ps.execute();
}}

