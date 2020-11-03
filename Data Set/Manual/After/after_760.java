public class Dummy{
@Override
public int setOrder(String[] nos, Bespeak order) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "";
        int count = 0, price = 0;
        sql = "SELECT order_sq.nextval FROM dual";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        rs.close();
        ps.close();
        for (String no : nos) {
            sql = "SELECT * FROM cart WHERE id=? AND no=? ";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, order.getId());
            ps.setObject(2, no);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
                price = rs.getInt("price");
            }
            ps.close();
            sql = "INSERT INTO bespeak (order_num, id, name, phone, address, no,  count, price, etc, bank, account) " + "VALUES (TO_CHAR(sysdate, 'yyyyMMdd') || LPAD(order_sq.currval, 3, '0'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, order.getId());
            ps.setObject(2, order.getName());
            ps.setObject(3, order.getPhone());
            ps.setObject(4, order.getAddress());
            ps.setObject(5, no);
            ps.setObject(6, count);
            ps.setObject(7, price);
            ps.setObject(8, order.getEtc());
            ps.setObject(9, order.getBank());
            ps.setObject(10, order.getAccount());
            cnt = ps.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - setOrder() ����");
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

