public class Dummy{
@Override
public int setHostMemberUpdate(String id, String memo, int rating) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "UPDATE member SET memo=?, rating=? WHERE id=?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, memo);
        ps.setObject(2, rating);
        ps.setObject(3, id);
        cnt = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("setHostMemberUpdate() ����");
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

