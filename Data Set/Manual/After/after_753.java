public class Dummy{
@Override
public int cartDelete(String id, String no) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "DELETE FROM cart WHERE id=? AND no=?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        ps.setObject(2, no);
        cnt = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - cartDelete() ����");
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

