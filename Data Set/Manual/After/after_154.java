public class Dummy{
public static void saveFeature(int movie_id, String pic) {
    int x = 0;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "INSERT INTO `movie_feature`(`movie_id`, `pic`) VALUES (?,?)";
        PreparedStatement pstm = con.prepareStatement(s);
        pstm.setObject(1, movie_id);
        pstm.setObject(2, pic);
        x = pstm.executeUpdate();
        con.close();
    } catch (Exception ex) {
        System.out.println("saveFeature error: " + ex);
    }
}}

