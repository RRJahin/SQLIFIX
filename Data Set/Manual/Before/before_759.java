public class Dummy{
public int wishlistCheck(String id, String no) {
    int cnt = 0;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * FROM wishlist WHERE id="+id+" AND no="+no;
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
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

