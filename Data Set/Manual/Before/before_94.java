public class Dummy{
public ArrayList<Bespeak> getOrderDetail(String order_num) {
    ArrayList<Bespeak> list = null;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        String sql = "SELECT * FROM bespeak WHERE order_num = "+order_num;
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
        if (rs.next()) {
            list = new ArrayList<>();
            do {
                Bespeak o = new Bespeak();
                o.setOrder_num(rs.getString("order_num"));
                o.setId(rs.getString("id"));
                o.setName(rs.getString("name"));
                o.setPhone(rs.getString("phone"));
                o.setAddress(rs.getString("address"));
                o.setNo(rs.getString("no"));
                o.setCount(rs.getInt("count"));
                o.setPrice(rs.getInt("price"));
                o.setEtc(rs.getString("etc"));
                o.setBank(rs.getString("bank"));
                o.setAccount(rs.getInt("account"));
                o.setOrder_state(rs.getInt("order_state"));
                list.add(o);
            } while (rs.next());
            rs.close();
        }
        ps.close();
        sql = "SELECT title, image FROM book WHERE no = ?";
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < list.size(); i += 1) {
            ps.setString(1, list.get(i).getNo());
            rs = ps.executeQuery();
            if (rs.next()) {
                list.get(i).setNos(rs.getString(1));
                list.get(i).setId(rs.getString(2));
                rs.close();
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - getOrderDetail() ����");
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

