public class Dummy{
public static ResultSet getPinnedPost(int count) {
    ResultSet result = null;
    try {
        conn = ConnectionProvider.getCon();
        pst = conn.prepareStatement("select * from pinnedposts where postid = ?");
        pst.setObject(1, count);
        result = pst.executeQuery();
        System.out.println("PostDAO: getting pinned post");
    } catch (Exception e) {
        System.out.println("PostDAO: unsuccessful query");
        System.out.println(e);
    }
    return result;
}}

