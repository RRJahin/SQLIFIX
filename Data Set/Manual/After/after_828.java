public class Dummy{
public void musicSave(Music m) throws SQLException {
    String sql = "insert into inception_music " + "( musicName, musicStyle," + " musicLanguage, artistName, albumName, " + "musicUrl, imageUrl, lyrics, " + "publishDate, description, " + "uploadedBy, uploadDate, fileLength, musicLength) " + "values (? , ? , ? , ? , ?, ?, ?, ? , ? , ?, ?, ?, ?, ?)";
    PreparedStatement ps = util.getConnection().prepareStatement(sql);
    ps.setObject(1, m.getMusicName());
    ps.setObject(2, m.getMusicStyle());
    ps.setObject(3, m.getMusicLanguage());
    ps.setObject(4, m.getArtistName());
    ps.setObject(5, m.getAlbumName());
    ps.setObject(6, m.getMusicUrl());
    ps.setObject(7, m.getImageUrl());
    ps.setObject(8, m.getLyrics());
    ps.setObject(9, m.getPublishDate());
    ps.setObject(10, m.getDescription());
    ps.setObject(11, m.getUploadedBy());
    ps.setObject(12, DateUtil.getDateTime());
    ps.setObject(13, m.getFileLength());
    ps.setObject(14, m.getMusicLength());
    ps.execute();
}}

