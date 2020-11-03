public class Dummy{
@Override
public ArrayList<Cart> getCartList(String id) {
    ArrayList<Cart> list = null;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * " + "FROM cart c, book b " + "WHERE c.no = b.no AND id = "+id;
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
        if (rs.next()) {
            list = new ArrayList<>();
            do {
                Cart c = new Cart();
                c.setId(rs.getString("id"));
                c.setNo(rs.getString("no"));
                c.setTitle(rs.getString("title"));
                c.setPrice(rs.getInt("price"));
                c.setCount(rs.getInt("count"));
                c.setImage(rs.getString("image"));
                list.add(c);
            } while (rs.next());
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - getCartList() ����");
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

