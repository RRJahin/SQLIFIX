public class Dummy{
@Override
public ArrayList<Bespeak> getMemberOrderList(String id) {
    ArrayList<Bespeak> list = null;
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    try {
        ArrayList<String> numList = new ArrayList<>();
        ArrayList<Bespeak> allList = new ArrayList<>();
        conn = datasource.getConnection();
        String sql = "SELECT DISTINCT order_num " + "FROM bespeak " + "WHERE id = "+id+" AND order_state NOT IN(7, 8, 9) " + "ORDER BY order_num DESC";
        ps = conn.createStatement();
        rs = ps.executeQuery(sql);
        if (rs.next()) {
            list = new ArrayList<>();
            do {
                numList.add(rs.getString(1));
            } while (rs.next());
            rs.close();
        }
        ps.close();
        sql = "SELECT * " + "FROM bespeak " + "WHERE id = ? AND order_state NOT IN(7, 8, 9) " + "ORDER BY order_num DESC";
        ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            Bespeak o = new Bespeak();
            o.setOrder_num(rs.getString("order_num"));
            o.setId(id);
            o.setName(rs.getString("name"));
            o.setPhone(rs.getString("phone"));
            o.setAddress(rs.getString("address"));
            o.setNo(rs.getString("no"));
            o.setCount(rs.getInt("count"));
            o.setPrice(rs.getInt("price"));
            o.setEtc(rs.getString("etc"));
            o.setAccount(rs.getInt("account"));
            o.setOrder_state(rs.getInt("order_state"));
            allList.add(o);
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
        System.out.println("MemberPersImpl - getOrder() ����");
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

