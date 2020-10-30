public class Dummy{
@Override
public int signUp(Member m) {
    int cnt = 0;
    Connection conn = null;
    Statement ps = null;
    try {
        conn = datasource.getConnection();
        String sql = "INSERT INTO member (id, pwd, name, phone, email, address, e_key) VALUES ("+m.getId()+", "+m.getPwd()+", "+m.getName()+", "+m.getPhone()+", "+m.getEmail()+", "+m.getAddress()+", "+m.getKey()+")";
        ps = conn.createStatement();
        cnt = ps.executeUpdate(sql);
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

