public class Dummy{
@Override
public ArrayList<Bespeak> getHostOrderList(int start, int end) {
    ArrayList<Bespeak> list = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = datasource.getConnection();
        ArrayList<String> numList = new ArrayList<>();
        ArrayList<Bespeak> allList = new ArrayList<>();
        String sql = "SELECT * " + "FROM(SELECT order_num, rownum as num " + "FROM (SELECT DISTINCT order_num " + "FROM bespeak " + "WHERE order_state NOT IN(7, 8, 9) " + "ORDER BY order_num DESC)) " + "WHERE num >= ? AND num <= ?";
        ps = conn.prepareStatement(sql);
        ps.setObject(1, start);
        ps.setObject(2, end);
        rs = ps.executeQuery();
        if (rs.next()) {
            list = new ArrayList<>();
            do {
                numList.add(rs.getString(1));
            } while (rs.next());
            rs.close();
        }
        ps.close();
        sql = "SELECT order_num, id, name, phone, address, no, count, price, etc, account, order_state FROM (SELECT * FROM bespeak WHERE order_state NOT IN (7, 8, 9) ORDER BY order_num DESC)";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Bespeak order = new Bespeak();
            order.setOrder_num(rs.getString("order_num"));
            order.setId(rs.getString("id"));
            order.setName(rs.getString("name"));
            order.setPhone(rs.getString("phone"));
            order.setAddress(rs.getString("address"));
            order.setNo(rs.getString("no"));
            order.setCount(rs.getInt("count"));
            order.setPrice(rs.getInt("price"));
            order.setEtc(rs.getString("etc"));
            order.setAccount(rs.getInt("account"));
            order.setOrder_state(rs.getInt("order_state"));
            allList.add(order);
        }
        rs.close();
        ps.close();
        int index = 0;
        for (int i = 0; i < numList.size(); i += 1) {
            int count = 0;
            for (int j = 0; j < allList.size(); j += 1) {
                String num = allList.get(j).getOrder_num();
                if (numList.get(i).equals(num)) {
                    if (count > 0) {
                        list.get(index - 1).setNos(" �� " + count + "��");
                    }
                    count += 1;
                    if (count == 1) {
                        list.add(allList.get(j));
                        index += 1;
                    }
                } else {
                    count = 0;
                }
            }
        }
        getNoTitle(list, conn, ps, rs);
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("MemberPersImpl - getOrderList() ����");
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

