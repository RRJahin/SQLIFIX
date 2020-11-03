public class Dummy{
@Override
public int orderDelete(String order_num) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "DELETE FROM bespeak WHERE order_num=?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, order_num);
        cnt = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("orderDelete() ����");
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

