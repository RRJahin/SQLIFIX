public class Dummy{
public Music getMusicById(int id) throws SQLException {
    String sql = "select * from inception_music where id = ?";
    PreparedStatement ps = util.getConnection().prepareStatement(sql);
    ps.setObject(1, id);
    ResultSet rs = ps.executeQuery();
    Music m = null;
    if (rs.next()) {
        m = new Music();
        setMusicInfo(m, rs);
    }
    return m;
}}

