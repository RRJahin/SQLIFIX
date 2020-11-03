public class Dummy{
public void musicSave(Music m) throws SQLException {
    String sql = "insert into inception_music " + "( musicName, musicStyle," + " musicLanguage, artistName, albumName, " + "musicUrl, imageUrl, lyrics, " + "publishDate, description, " + "uploadedBy, uploadDate, fileLength, musicLength) " + "values ("+m.getMusicName()+" , "+m.getMusicStyle()+" , "+m.getMusicLanguage()+" , "+m.getArtistName()+" , "+m.getAlbumName()+", "+m.getMusicUrl()+", "+m.getImageUrl()+", "+m.getLyrics()+" , "+m.getPublishDate()+" , "+m.getDescription()+", "+m.getUploadedBy()+", "+DateUtil.getDateTime()+", "+m.getFileLength()+", "+m.getMusicLength()+")";
    Statement ps = util.getConnection().createStatement();
    ps.executeQuery(sql);
}}

