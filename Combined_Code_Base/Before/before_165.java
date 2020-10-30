public class Dummy{
public void updateBaiscInfo(Music music) throws SQLException {
    String sql = "update inception_music set musicName = "+ music.getMusicName()+", musicStyle = "+music.getMusicStyle()+"," + " musicLanguage = "+music.getMusicLanguage()+", artistName = "+music.getArtistName()+", albumName = "+music.getAlbumName()+" where id = "+music.getId();
    Statement ps = util.getConnection().createStatement();
    ps.executeQuery(sql);
}}

