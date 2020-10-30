public class Dummy{
@Override
public int setCartCount(String id, String no, int count) {
    int cnt = 0;
    String sql = "";
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        sql = "UPDATE cart SET count=? WHERE id=? AND no=?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, count);
        ps.setObject(2, id);
        ps.setObject(3, no);
        cnt = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - setCartCount() ����");
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

