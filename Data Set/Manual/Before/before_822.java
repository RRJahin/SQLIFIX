public class Dummy{
public static movie_feature findById(int movie_id) {
    movie_feature m = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "select * from movie_feature where movie_id = "+movie_id;
        Statement pstm = con.createStatement();
        ResultSet rs = pstm.executeQuery(s);
        if (rs.next()) {
            m = new movie_feature();
            m.setMovie_id(rs.getInt("movie_id"));
            m.setPic(rs.getString("pic"));
            m.setDatepost(rs.getTimestamp("datepost"));
        }
        con.close();
    } catch (Exception ex) {
        System.out.println("movie_feature findById error: " + ex);
    }
    return m;
}}

