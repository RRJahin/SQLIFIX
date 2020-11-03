public class Dummy{
public int memberEmailKeyUpdate(String id, String key) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "UPDATE member SET e_key=? WHERE id=?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, key);
        ps.setObject(2, id);
        cnt = ps.executeUpdate();
        System.out.println(id + " - " + key + ": �ƾƵ�/��й�ȣ ���� ����");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("pwdFindEmailKey() ����");
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

