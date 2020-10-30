public class Dummy{
public int confirmEmailKey(String key) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * FROM member WHERE e_key=?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, key);
        rs = ps.executeQuery();
        if (rs.next()) {
            String id = rs.getString("id");
            ps.close();
            sql = "UPDATE member SET rating=3 WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            cnt = ps.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("confirmEmailKey() ����");
    } finally {
        try {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return cnt;
}}

