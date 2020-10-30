public class Dummy{
public static ResultSet getPinnedPost(int count) {
    ResultSet result = null;
    try {
        conn = ConnectionProvider.getCon();
        pst = conn.createStatement();
        result = pst.executeQuery("select * from pinnedposts where postid = "+count);
        System.out.println("PostDAO: getting pinned post");
    } catch (Exception e) {
        System.out.println("PostDAO: unsuccessful query");
        System.out.println(e);
    }
    return result;
}}

