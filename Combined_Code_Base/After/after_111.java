public class Dummy{
public boolean isValidMember() throws Exception {
    String sql = "SELECT * FROM member WHERE account=? AND passwd=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setObject(1, account);
    pstmt.setObject(2, passwd);
    ResultSet rs = pstmt.executeQuery();
    boolean ret = rs.next();
    if (ret) {
        id = rs.getString("id");
        realName = rs.getString("realname");
    }
    return ret;
}}

