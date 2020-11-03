public class Dummy{
public String getPwd(String key) {
    String pwd = null;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT pwd FROM member WHERE e_key="+key;
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
        if (rs.next()) {
            pwd = rs.getString("pwd");
            System.out.println(pwd);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("getPwd() ����");
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
    return pwd;
}}

