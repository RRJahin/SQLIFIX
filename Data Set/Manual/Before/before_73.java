public class Dummy{
@Override
public int signIn(String strId, String strPwd) {
    int cnt = 0;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * FROM member WHERE id = "+strId;
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
        if (rs.next()) {
            if (strPwd.equals(rs.getString("pwd"))) {
                cnt = 1;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - SignIn ����");
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
    return cnt;
}}

