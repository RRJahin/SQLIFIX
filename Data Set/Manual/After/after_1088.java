public class Dummy{
public int getCount(int i) throws SQLException {
    String sql = "select COUNT(*) from inception_preference where userId = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setObject(1, i);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        return rs.getInt(1);
    }
    return 0;
}}

