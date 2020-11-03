public class Dummy{
public List<Preference> getPreferenceLimit(int userId, int start, int count) throws SQLException {
    List<Preference> list = new ArrayList<Preference>();
    String sql = "select * from inception_preference where userId = ? order by id desc limit ?, ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setObject(1, userId);
    ps.setObject(2, start);
    ps.setObject(3, count);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        Preference p = new Preference();
        setInfo(p, rs);
        list.add(p);
    }
    return list;
}}

