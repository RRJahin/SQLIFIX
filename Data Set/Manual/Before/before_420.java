public class Dummy{
public List<Music> getAllMusic(int id) throws SQLException {
    List<Music> list = new ArrayList<Music>();
    String sql = "select * from inception_preference, inception_music where inception_preference.userId = "+id+" and inception_preference.musicId = inception_music.id";
    Statement ps = conn.createStatement();
    ResultSet rs = ps.executeQuery(sql);
    while (rs.next()) {
        Music m = new Music();
        setMusicInfo(m, rs);
        list.add(m);
    }
    return list;
}}

