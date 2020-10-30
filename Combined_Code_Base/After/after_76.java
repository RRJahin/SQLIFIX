public class Dummy{
public String confirmEmail(String email) {
    String id = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT id FROM member WHERE email=?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, email);
        rs = ps.executeQuery();
        if (rs.next()) {
            id = rs.getString("id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("confirmEmail() ����");
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
    return id;
}}

