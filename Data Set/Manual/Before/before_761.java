public class Dummy{
@Override
public int setNowOrder(String no, Bespeak order, int nowCount) {
    int cnt = 0;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "";
        int price = 0;
        sql = "SELECT * FROM book WHERE no = "+no;
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
        if (rs.next()) {
            price = rs.getInt("price");
        }
        ps.close();
        sql = "INSERT INTO bespeak bespeak (order_num, id, name, phone, address, no,  count, price, etc, bank, account) " + "VALUES (TO_CHAR(sysdate, 'yyyyMMdd') || LPAD(order_sq.nextval, 3, '0'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, order.getId());
        ps.setString(2, order.getName());
        ps.setString(3, order.getPhone());
        ps.setString(4, order.getAddress());
        ps.setString(5, no);
        ps.setInt(6, nowCount);
        ps.setInt(7, price);
        ps.setString(8, order.getEtc());
        ps.setString(9, order.getBank());
        ps.setInt(10, order.getAccount());
        cnt = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - setNowOrder() ����");
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

