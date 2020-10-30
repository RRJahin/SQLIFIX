public class Dummy{
@Override
public int setCart(String id, Book b, int count) {
    int cnt = 0;
    Connection conn = null;
    Statement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "INSERT INTO cart VALUES ("+id+", "+b.getNo()+", "+b.getTitle()+", "+b.getPrice()+", "+count+", "+b.getImage()+")";
        ps = conn.createStatement();
        cnt = ps.executeUpdate(sql);
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

