public class Dummy{
public List<Movie> viewAllMovie(int user_id, int offset, int noOfRecords) {
    List<Movie> lm = null;
    Movie m = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "select SQL_CALC_FOUND_ROWS m.* FROM movie m JOIN order_movie om ON m.movie_id = om.movie_id JOIN user_order uo ON uo.order_id = om.order_id \n" + "JOIN user u ON u.user_id = uo.user_id\n" + "WHERE u.user_id = "+user_id+" AND uo.confirm_no = 1 ORDER BY uo.date_create desc limit "+offset+", "+noOfRecords;
        Statement pstm = con.createStatement();
        ResultSet rs = pstm.executeQuery(s);
        while (rs.next()) {
            if (lm == null) {
                lm = new ArrayList<>();
            }
            m = new Movie();
            m.setName(rs.getString("name"));
            m.setMovie_id(rs.getInt("movie_id"));
            m.setDescription(rs.getString("description"));
            m.setPrice(rs.getInt("price"));
            m.setRegdate(rs.getString("regdate"));
            m.setReleasedyear(rs.getString("releasedyear"));
            m.setTotaltime(rs.getString("totaltime"));
            m.setPoster((rs.getString("poster")));
            lm.add(m);
        }
        rs.close();
        pstm = con.createStatement();
        rs = pstm.executeQuery("SELECT FOUND_ROWS()");
        if (rs.next())
            this.noOfRecords = rs.getInt(1);
    } catch (Exception ex) {
        System.out.println("Movie viewAllMovie error: " + ex);
    }
    return lm;
}}

