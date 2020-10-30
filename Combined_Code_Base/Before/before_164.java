public class Dummy{
public Music findMusicByUrl(String url) throws SQLException {
    String sql = "select * from inception_music where musicUrl = "+url;
    Statement ps = util.getConnection().createStatement();
    ResultSet rs = ps.executeQuery(sql);
    Music m = null;
    if (rs.next()) {
        m = new Music();
        setMusicInfo(m, rs);
    }
    return m;
}}

