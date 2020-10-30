public class Dummy{
public List<Movie> viewAllMovie(int user_id, String category, int offset, int noOfRecords) {
    List<Movie> lm = null;
    Movie m = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "select SQL_CALC_FOUND_ROWS * FROM movie m JOIN order_movie om ON m.movie_id = om.movie_id JOIN user_order uo ON uo.order_id = om.order_id\n" + "JOIN user u ON u.user_id = uo.user_id JOIN categories c ON c.category_id = m.category_id\n" + "WHERE u.user_id = ? AND c.name = ? AND uo.confirm_no = 1 ORDER BY uo.date_create desc limit ?,? ";
        PreparedStatement pstm = con.prepareStatement(s);
        pstm.setObject(1, user_id);
        pstm.setObject(2, category);
        pstm.setObject(3, offset);
        pstm.setObject(4, noOfRecords);
        ResultSet rs = pstm.executeQuery();
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
        pstm = con.prepareStatement("SELECT FOUND_ROWS()");
        rs = pstm.executeQuery();
        if (rs.next())
            this.noOfRecords = rs.getInt(1);
    } catch (Exception ex) {
        System.out.println("Movie viewAllMovie error: " + ex);
    }
    return lm;
}}

