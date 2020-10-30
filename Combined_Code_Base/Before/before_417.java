public class Dummy{
public List<Preference> getPreferenceLimit(int userId, int start, int count) throws SQLException {
    List<Preference> list = new ArrayList<Preference>();
    String sql = "select * from inception_preference where userId = "+userId+" order by id desc limit "+start+", "+count;
    Statement ps = conn.createStatement();
    ResultSet rs = ps.executeQuery(sql);
    while (rs.next()) {
        Preference p = new Preference();
        setInfo(p, rs);
        list.add(p);
    }
    return list;
}}

