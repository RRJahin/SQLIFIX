public class Dummy{
public static int getUserPostTotal(String userid) {
    int total = 0;
    try {
        conn = ConnectionProvider.getCon();
        pst = conn.prepareStatement("select count(*) from normalposts where authorid = ?");
        pst.setObject(1, userid);
        ResultSet rs = pst.executeQuery();
        rs.next();
        total = rs.getInt(1);
        conn.close();
    } catch (Exception e) {
        System.out.println("PostDAO: get user post total failed");
        System.out.println(e);
    }
    return total;
}}

