public class Dummy{
public static void deleteFeature(int movie_id) {
    int x = 0;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "DELETE FROM `movie_feature` where movie_id = "+movie_id;
        Statement pstm = con.createStatement();
        x = pstm.executeUpdate(s);
        con.close();
    } catch (Exception ex) {
        System.out.println("deleteWishlist error: " + ex);
    }
}}

