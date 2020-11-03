public class Dummy{
public void musicCTRInc(int id) throws SQLException {
    String sql = "update inception_music set CTR = CTR + 1 where id = "+id;
    Statement ps = util.getConnection().createStatement();
    ps.execute(sql);
}}

