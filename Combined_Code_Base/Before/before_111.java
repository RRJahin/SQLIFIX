public class Dummy{
public boolean isValidMember() throws Exception {
    String sql = "SELECT * FROM member WHERE account="+account+" AND passwd="+passwd;
    Statement pstmt = conn.createStatement();
    ResultSet rs = pstmt.executeQuery(sql);
    boolean ret = rs.next();
    if (ret) {
        id = rs.getString("id");
        realName = rs.getString("realname");
    }
    return ret;
}}

