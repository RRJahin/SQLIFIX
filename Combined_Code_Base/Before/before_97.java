public class Dummy{
@Override
public int getHostOrderCnt() {
    int cnt = 0;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT COUNT(DISTINCT order_num) FROM bespeak WHERE order_state NOT IN(7, 8, 9)";
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
        if (rs.next()) {
            cnt = rs.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("getOrderCnt() ����");
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

