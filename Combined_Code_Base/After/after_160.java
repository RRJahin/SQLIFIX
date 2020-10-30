public class Dummy{
public void musicCTRInc(int id) throws SQLException {
    String sql = "update inception_music set CTR = CTR + 1 where id = ?";
    PreparedStatement ps = util.getConnection().prepareStatement(sql);
    ps.setObject(1, id);
    ps.execute();
}}

