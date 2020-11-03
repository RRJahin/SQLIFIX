public class Dummy{
public void delete(int id) throws SQLException {
    String sql = "delete from inception_preference where id = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setObject(1, id);
    ps.execute();
}}

