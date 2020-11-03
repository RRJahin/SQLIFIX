public class Dummy{
@Override
public int shippingInsert(String order, String ship) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "INSERT INTO shipping VALUES (?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, order);
        ps.setObject(2, ship);
        cnt = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("shippingInsert() ����");
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

