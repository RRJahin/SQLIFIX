public class Dummy{
@Override
public int setCartCount(String id, String no, int count) {
    int cnt = 0;
    String sql = "";
    Connection conn = null;
    Statement ps = null;
    try {
        conn = datasource.getConnection();
        sql = "UPDATE cart SET count="+count+" WHERE id="+id+" AND no="+no;
        ps = conn.createStatement();
        cnt = ps.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - setCartCount() ����");
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

