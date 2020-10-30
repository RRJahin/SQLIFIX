public class Dummy{
public int setHostMemberAllDelete(String id) {
    int cnt = 0;
    String[] ids = id.split(",");
    Connection conn = null;
    Statement ps = null;
    try {
        conn = datasource.getConnection();
        String sql;
        ps = conn.createStatement();
        for (String strId : ids) {
            sql = "DELETE FROM member WHERE id="+strId;
            cnt = ps.executeUpdate(sql);
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

