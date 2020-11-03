public class Dummy{
public void delete(int id) throws SQLException {
    String sql = "delete from inception_preference where id = "+id;
    Statement ps = conn.createStatement();
    ps.execute(sql);
}}

