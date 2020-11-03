public class Dummy{
public static ResultSet getUserPost(String userid) {
    ResultSet result = null;
    try {
        conn = ConnectionProvider.getCon();
        pst = conn.prepareStatement("select * from normalposts where authorid = ?");
        pst.setObject(1, userid);
        result = pst.executeQuery();
        System.out.println("PostDAO: getting posts written by " + userid);
    } catch (Exception e) {
        System.out.println("PostDAO: getUserPost unsuccessful");
        System.out.println(e);
    }
    return result;
}}

