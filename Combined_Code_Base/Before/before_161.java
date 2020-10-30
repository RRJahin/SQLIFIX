public class Dummy{
public void musicCTRInc(String musicUrl) throws SQLException {
    String sql = "update inception_music set CTR = CTR + 1 where musicUrl = "+musicUrl;
    Statement ps = util.getConnection().createStatement();
    ps.execute(sql);
}}

