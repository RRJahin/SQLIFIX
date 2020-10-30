public class Dummy{
@Override
public int cartCheck(String id, String no) {
    int count = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * FROM cart WHERE id=? AND no=?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        ps.setObject(2, no);
        rs = ps.executeQuery();
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

