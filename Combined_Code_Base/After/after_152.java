public class Dummy{
public List<Movie> viewAllMovie(String category, int offset, int noOfRecords) {
    List<Movie> lm = null;
    Movie m = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "select SQL_CALC_FOUND_ROWS * from movie m join categories c on m.category_id = c.category_id where c.name = ? ORDER BY movie_id DESC limit ?,? ";
        PreparedStatement pstm = con.prepareStatement(s);
        pstm.setObject(1, category);
        pstm.setObject(2, offset);
        pstm.setObject(3, noOfRecords);
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

