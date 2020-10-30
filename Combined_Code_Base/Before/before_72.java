public class Dummy{
public int confirmEmailKey(String key) {
    int cnt = 0;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * FROM member WHERE e_key="+key;
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
        if (rs.next()) {
            String id = rs.getString("id");
            ps.close();
            sql = "UPDATE member SET rating=3 WHERE id="+id;
            ps = conn.createStatement();
            cnt = ps.executeUpdate(sql);
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

