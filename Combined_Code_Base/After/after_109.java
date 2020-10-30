public class Dummy{
@Override
public void getNoTitle(ArrayList<Bespeak> list, Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
    if (list != null) {
        String sql = "SELECT title FROM book WHERE no = ?";
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < list.size(); i += 1) {
            Bespeak b = list.get(i);
            ps.setObject(1, b.getNo());
            rs = ps.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                b.setNos(title + b.getNos());
                list.set(i, b);
                rs.close();
            }
        }
    }
}}

