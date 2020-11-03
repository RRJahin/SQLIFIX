public class Dummy{
@Override
public ArrayList<Member> getMemberList(int start, int end) {
    ArrayList<Member> list = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * " + "FROM (SELECT id, pwd, name, phone, email, address, memo, rating, rownum as num FROM member) " + "WHERE num >= ? AND num <= ?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, start);
        ps.setObject(2, end);
        rs = ps.executeQuery();
        if (rs.next()) {
            list = new ArrayList<>();
            do {
                Member m = new Member();
                m.setId(rs.getString("id"));
                m.setPwd(rs.getString("pwd"));
                m.setName(rs.getString("name"));
                m.setPhone(rs.getString("phone"));
                m.setEmail(rs.getString("email"));
                m.setAddress(rs.getString("address"));
                m.setMemo(rs.getString("memo"));
                m.setRating(rs.getInt("rating"));
                list.add(m);
            } while (rs.next());
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("getMemberList() ����");
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
    return list;
}}

