public class Dummy{
public int getCount(int i) throws SQLException {
    String sql = "select COUNT(*) from inception_preference where userId = "+i;
    Statement ps = conn.createStatement();
    ResultSet rs = ps.executeQuery(sql);
    if (rs.next()) {
        return rs.getInt(1);
    }
    return 0;
}}

