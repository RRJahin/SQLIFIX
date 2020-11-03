public class Dummy{
public void deleteMusicById(int id) throws SQLException {
    String sql = "delete from inception_music where id = ?";
    PreparedStatement ps = util.getConnection().prepareStatement(sql);
    ps.setObject(1, id);
    ps.execute();
}}

