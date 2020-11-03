public class Dummy{
@Override
public Member getMemberInfo(String strId) {
    Member m = new Member();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * FROM member WHERE id = ?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, strId);
        rs = ps.executeQuery();
        if (rs.next()) {
            m.setId(strId);
            m.setPwd(rs.getString("pwd"));
            m.setName(rs.getString("name"));
            m.setPhone(rs.getString("Phone"));
            m.setEmail(rs.getString("email"));
            m.setAddress(rs.getString("address"));
            m.setMemo(rs.getString("memo"));
            m.setRating(rs.getInt("rating"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
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
    return m;
}}

