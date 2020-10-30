public class Dummy{
@Override
public int setHostMemberAllUpdate(String id, String memo, String rating) {
    int cnt = 0;
    String[] ids = id.split(",");
    String[] memos = memo.split(",");
    String[] ratings = rating.split(",");
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "UPDATE member SET memo=?, rating=? WHERE id=?";
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < ids.length; i += 1) {
            ps.setObject(1, memos[i]);
            ps.setObject(2, Integer.parseInt(ratings[i]));
            ps.setObject(3, ids[i]);
            System.out.println(ids[i]);
            cnt = ps.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("setHostMemberAllUpdate() ����");
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

