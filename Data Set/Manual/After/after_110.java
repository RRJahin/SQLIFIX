public class Dummy{
public boolean newInsert() throws Exception {
    pstmt = conn.prepareStatement("INSERT INTO member (account,passwd,realname) VALUES (?,?,?)");
    pstmt.setObject(1, account);
    pstmt.setObject(2, passwd);
    pstmt.setObject(3, realName);
    int n = pstmt.executeUpdate();
    return n > 0;
}}

