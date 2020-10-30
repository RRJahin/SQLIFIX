public class Dummy{
@Override
public void getNoTitle(ArrayList<Bespeak> list, Connection conn, Statement ps, ResultSet rs) throws SQLException {
    if (list != null) {
        String sql;
        ps = conn.createStatement();
        for (int i = 0; i < list.size(); i += 1) {
            Bespeak b = list.get(i);
            sql = "SELECT title FROM book WHERE no = "+b.getNo();
            rs = ps.executeQuery(sql);
            if (rs.next()) {
                String title = rs.getString("title");
                b.setNos(title + b.getNos());
                list.set(i, b);
                rs.close();
            }
        }
    }
}}

