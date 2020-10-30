public class Dummy{
@Override
public int setCart(String id, Book b, int count) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "INSERT INTO cart VALUES (?, ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        ps.setObject(2, b.getNo());
        ps.setObject(3, b.getTitle());
        ps.setObject(4, b.getPrice());
        ps.setObject(5, count);
        ps.setObject(6, b.getImage());
        cnt = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - setCart() ����");
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

