public class Dummy{
@Override
public int signUp(Member m) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "INSERT INTO member (id, pwd, name, phone, email, address, e_key) VALUES (?, ?, ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, m.getId());
        ps.setObject(2, m.getPwd());
        ps.setObject(3, m.getName());
        ps.setObject(4, m.getPhone());
        ps.setObject(5, m.getEmail());
        ps.setObject(6, m.getAddress());
        ps.setObject(7, m.getKey());
        cnt = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl signUp ����");
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

