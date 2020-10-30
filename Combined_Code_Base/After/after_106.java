public class Dummy{
public int setHostMemberAllDelete(String id) {
    int cnt = 0;
    String[] ids = id.split(",");
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "DELETE FROM member WHERE id=?";
        ps = conn.prepareStatement(sql);
        for (String strId : ids) {
            ps.setObject(1, strId);
            cnt = ps.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("setHostMemberAllDelete() ����");
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

