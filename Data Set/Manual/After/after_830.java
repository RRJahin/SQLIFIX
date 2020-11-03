public class Dummy{
public void musicCTRInc(String musicUrl) throws SQLException {
    String sql = "update inception_music set CTR = CTR + 1 where musicUrl = ?";
    PreparedStatement ps = util.getConnection().prepareStatement(sql);
    ps.setObject(1, musicUrl);
    ps.execute();
}}

