public class Dummy{
public String getLrc(String url) throws SQLException {
    String sql = "select * from inception_music where musicUrl = "+url;
    Statement ps = util.getConnection().createStatement();
    ResultSet rs = ps.executeQuery(sql);
    String lrc = "";
    if (rs.next()) {
        lrc = rs.getString("lyrics");
    }
    return lrc;
}}

