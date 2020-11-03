public class Dummy{
public int wishlistCheck(String id, String no) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * FROM wishlist WHERE id=? AND no=?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        ps.setObject(2, no);
        rs = ps.executeQuery();
        if (rs.next()) {
            cnt = 9;
        }
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

