public class Dummy{
public List<movie_feature> viewAllFeature(int offset, int noOfRecords) {
    List<movie_feature> lmf = null;
    movie_feature mf = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "select SQL_CALC_FOUND_ROWS * from movie_feature WHERE datepost < CURRENT_TIMESTAMP ORDER BY datepost DESC limit ?,?";
        PreparedStatement pstm = con.prepareStatement(s);
        pstm.setObject(1, offset);
        pstm.setObject(2, noOfRecords);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            if (lmf == null) {
                lmf = new ArrayList<>();
            }
            mf = new movie_feature();
            mf.setMovie_id(rs.getInt("movie_id"));
            mf.setPic(rs.getString("pic"));
            mf.setObjectpost(rs.getTimestamp("datepost"));
            lmf.add(mf);
        }
        rs.close();
        pstm = con.prepareStatement("SELECT FOUND_ROWS()");
        rs = pstm.executeQuery();
        if (rs.next())
            this.noOfRecords = rs.getInt(1);
    } catch (Exception ex) {
        System.out.println("Movie FindByName error: " + ex);
    }
    return lmf;
}}

