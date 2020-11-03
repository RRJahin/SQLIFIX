public class Dummy{
public boolean newInsert() throws Exception {
    pstmt = conn.createStatement();
    int n = pstmt.executeUpdate("INSERT INTO member (account,passwd,realname) VALUES ("+account+","+passwd+","+realName+")");
    return n > 0;
}}

