public class Dummy{
public Music findMusicByUrl(String url) throws SQLException {
    String sql = "select * from inception_music where musicUrl = ?";
    PreparedStatement ps = util.getConnection().prepareStatement(sql);
    ps.setObject(1, url);
    ResultSet rs = ps.executeQuery();
    Music m = null;
    if (rs.next()) {
        m = new Music();
        setMusicInfo(m, rs);
    }
    return m;
}}

