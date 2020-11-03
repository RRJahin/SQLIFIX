public class Dummy{
public List<Music> getListByAlbum(String album) throws SQLException {
    String sql = "select * from inception_music where albumName = " + album;
    Statement ps = conn.createStatement();
    ResultSet rs = ps.executeQuery(sql);
    List<Music> list = new ArrayList<Music>();
    while (rs.next()) {
        Music m = new Music();
        setMusicInfo(m, rs);
        list.add(m);
    }
    return list;
}}

