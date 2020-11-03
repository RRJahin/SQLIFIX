public class Dummy{
public String getShipping(String order_num) {
    String ship_num = null;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * FROM shipping WHERE order_num = "+order_num;
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
        if (rs.next()) {
            ship_num = rs.getString("ship_num");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - getShipping() ����");
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
    return ship_num;
}}

