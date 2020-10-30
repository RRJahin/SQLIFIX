public class Dummy{
public static List<movie_feature> getShowFeature(int NoPage) {
    List<movie_feature> lmf = null;
    movie_feature lm = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "SELECT * FROM `movie_feature` WHERE datepost < CURRENT_TIMESTAMP order by datepost desc LIMIT 0,"+NoPage;
        Statement pstm = con.createStatement();
        ResultSet rs = pstm.executeQuery(s);
        while (rs.next()) {
            if (lmf == null) {
                lmf = new ArrayList<>();
            }
            lm = new movie_feature();
            lm.setMovie_id(rs.getInt("movie_id"));
            lm.setPic(rs.getString("pic"));
            lm.setDatepost(rs.getTimestamp("datepost"));
            lmf.add(lm);
        }
        con.close();
    } catch (Exception ex) {
        System.out.println("Movie recenlyMovie error: " + ex);
    }
    return lmf;
}}

