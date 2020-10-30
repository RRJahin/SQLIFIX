public class Dummy{
public void deleteMusicById(int id) throws SQLException {
    String sql = "delete from inception_music where id = "+id;
    Statement ps = util.getConnection().prepareStatement();
    ps.execute(sql);
}}

