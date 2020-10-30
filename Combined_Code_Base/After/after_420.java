public class Dummy{
public List<Music> getAllMusic(int id) throws SQLException {
    List<Music> list = new ArrayList<Music>();
    String sql = "select * from inception_preference, inception_music where inception_preference.userId = ? and inception_preference.musicId = inception_music.id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setObject(1, id);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        Music m = new Music();
        setMusicInfo(m, rs);
        list.add(m);
    }
    return list;
}}

