public class Dummy{
public static List<movie_pic> getAllImage(int id) {
    List<movie_pic> mp_list = null;
    movie_pic mp = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "SELECT mp.* FROM `movie_pic` mp JOIN movie m on m.movie_id = mp.movie_id WHERE m.movie_id = "+id;
        Statement pstm = con.createStatement();
        ResultSet rs = pstm.executeQuery(s);
        while (rs.next()) {
            if (mp_list == null) {
                mp_list = new ArrayList<>();
            }
            mp = new movie_pic();
            mp.setMovie_id(rs.getInt("movie_id"));
            mp.setPic_id(rs.getInt("pic_id"));
            mp.setPic(rs.getString("pic"));
            mp_list.add(mp);
        }
        con.close();
    } catch (Exception ex) {
        System.out.println("getAllImage error: " + ex);
    }
    return mp_list;
}}

