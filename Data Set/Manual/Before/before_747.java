public class Dummy{
public String getId(String key) {
    String id = null;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT id FROM member WHERE e_key="+key;
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
        if (rs.next()) {
            id = rs.getString("id");
            System.out.println(id);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("getId() ����");
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

