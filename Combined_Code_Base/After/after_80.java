public class Dummy{
@Override
public int memberUpdate(Member m) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "UPDATE member SET pwd=?, name=?, phone=?, email=?, address=? WHERE id = ?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, m.getPwd());
        ps.setObject(2, m.getName());
        ps.setObject(3, m.getPhone());
        ps.setObject(4, m.getEmail());
        ps.setObject(5, m.getAddress());
        ps.setObject(6, m.getId());
        cnt = ps.executeUpdate();
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

