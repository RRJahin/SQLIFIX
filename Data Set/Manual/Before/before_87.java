public class Dummy{
@Override
public int cartCheck(String id, String no) {
    int count = 0;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * FROM cart WHERE id="+id+" AND no="+no;
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
        if (rs.next()) {
            count = rs.getInt("count");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - cartCheck() ����");
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
    return count;
}}
