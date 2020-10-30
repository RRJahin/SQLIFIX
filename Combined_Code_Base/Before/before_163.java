public class Dummy{
public Music getMusicById(int id) throws SQLException {
    String sql = "select * from inception_music where id = ",+id;
    Statement ps = util.getConnection().createStatement();
    ResultSet rs = ps.executeQuery(sql);
    Music m = null;
    if (rs.next()) {
        m = new Music();
        setMusicInfo(m, rs);
    }
    return m;
}}

