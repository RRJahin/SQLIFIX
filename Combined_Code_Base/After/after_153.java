public class Dummy{
public static movie_feature findById(int movie_id) {
    movie_feature m = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "select * from movie_feature where movie_id = ?";
        PreparedStatement pstm = con.prepareStatement(s);
        pstm.setObject(1, movie_id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            m = new movie_feature();
            m.setMovie_id(rs.getInt("movie_id"));
            m.setPic(rs.getString("pic"));
            m.setObjectpost(rs.getTimestamp("datepost"));
        }
        con.close();
    } catch (Exception ex) {
        System.out.println("movie_feature findById error: " + ex);
    }
    return m;
}}

