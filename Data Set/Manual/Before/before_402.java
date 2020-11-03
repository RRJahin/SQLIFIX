public class Dummy{
public static int getUserPostTotal(String userid) {
    int total = 0;
    try {
        conn = ConnectionProvider.getCon();
        pst = conn.createStatement();
        ResultSet rs = pst.executeQuery("select count(*) from normalposts where authorid = "+userid);
        rs.next();
        total = rs.getInt(1);
        conn.close();
    } catch (Exception e) {
        System.out.println("PostDAO: get user post total failed");
        System.out.println(e);
    }
    return total;
}}

