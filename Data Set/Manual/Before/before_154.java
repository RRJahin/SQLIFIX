public class Dummy{
public static void saveFeature(int movie_id, String pic) {
    int x = 0;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "INSERT INTO `movie_feature`(`movie_id`, `pic`) VALUES ("+movie_id+","+pic+")";
        Statement pstm = con.createStatement();
        x = pstm.executeUpdate(s);
        con.close();
    } catch (Exception ex) {
        System.out.println("saveFeature error: " + ex);
    }
}}

