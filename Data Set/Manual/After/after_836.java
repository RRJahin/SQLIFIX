public class Dummy{
public String getLrc(String url) throws SQLException {
    String sql = "select * from inception_music where musicUrl = ?";
    PreparedStatement ps = util.getConnection().prepareStatement(sql);
    ps.setObject(1, url);
    ResultSet rs = ps.executeQuery();
    String lrc = "";
    if (rs.next()) {
        lrc = rs.getString("lyrics");
    }
    return lrc;
}}

