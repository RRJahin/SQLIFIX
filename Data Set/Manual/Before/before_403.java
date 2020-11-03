public class Dummy{
public static ResultSet getUserPost(String userid) {
    ResultSet result = null;
    try {
        conn = ConnectionProvider.getCon();
        pst = conn.createStatement();
        result = pst.executeQuery("select * from normalposts where authorid = "+userid);
        System.out.println("PostDAO: getting posts written by " + userid);
    } catch (Exception e) {
        System.out.println("PostDAO: getUserPost unsuccessful");
        System.out.println(e);
    }
    return result;
}}

