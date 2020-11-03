public class Dummy{
public static void deleteFeature(int movie_id) {
    int x = 0;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "DELETE FROM `movie_feature` where movie_id = ?";
        PreparedStatement pstm = con.prepareStatement(s);
        pstm.setObject(1, movie_id);
        x = pstm.executeUpdate();
        con.close();
    } catch (Exception ex) {
        System.out.println("deleteWishlist error: " + ex);
    }
}}

