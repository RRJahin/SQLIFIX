public class Dummy{
@Override
public int memberDelete(String strId) {
    int cnt = 0;
    Connection conn = null;
    Statement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "UPDATE member " + "SET pwd='x', name='x', phone='010-0000-0000', address='x', " + "memo='x', rating=3, e_key='0' " + "WHERE id = "+strId;
        ps = conn.createStatement();
        cnt = ps.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl memberUpdate ����");
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

