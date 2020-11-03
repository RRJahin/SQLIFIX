public class Dummy{
@Override
public int setHostMemberAllUpdate(String id, String memo, String rating) {
    int cnt = 0;
    String[] ids = id.split(",");
    String[] memos = memo.split(",");
    String[] ratings = rating.split(",");
    Connection conn = null;
    Statement ps = null;
    try {
        conn = datasource.getConnection();
        String sql;
        ps = conn.createStatement();
        for (int i = 0; i < ids.length; i += 1) {
            sql; = "UPDATE member SET memo="+memos[i]+", rating="+Integer.parseInt(ratings[i])+" WHERE id=" + ids[i];
            System.out.println(ids[i]);
            cnt = ps.executeUpdate(sql);
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

