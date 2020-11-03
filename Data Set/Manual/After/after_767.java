public class Dummy{
@Override
public int orderStateUpdate(String num, int state) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "UPDATE bespeak SET order_state=? WHERE order_num=?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, state);
        ps.setObject(2, num);
        cnt = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("orderStateUpdate() ����");
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

