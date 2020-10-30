public class Dummy{
@Override
public int memberUpdate(Member m) {
    int cnt = 0;
    Connection conn = null;
    Statement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "UPDATE member SET pwd="+m.getPwd()+", name="+m.getName()+", phone="+m.getPhone()+", email="+m.getEmail()+", address="+m.getAddress()+" WHERE id = "+m.getId();
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

