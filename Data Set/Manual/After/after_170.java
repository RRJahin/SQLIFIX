public class Dummy{
public List<Music> getListByAlbum(String album) throws SQLException {
    String sql = "select * from inception_music where albumName = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setObject(1, album);
    ResultSet rs = ps.executeQuery();
    List<Music> list = new ArrayList<Music>();
    while (rs.next()) {
        Music m = new Music();
        setMusicInfo(m, rs);
        list.add(m);
    }
    return list;
}}

