public class Dummy{
public int setWishlist(String id, String no) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "INSERT INTO wishlist VALUES (?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        ps.setObject(2, no);
        cnt = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("setWishlist() ����");
    } finally {
        try {
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

