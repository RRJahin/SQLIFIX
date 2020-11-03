public class Dummy{
public static void updateMemberUsername(Connection conn, Starwood member, String oldUserName) throws SQLException {
    String sql = "Update Starwood set User_Name ="+member.getUserName()+"  where Id="+member.getId().toString();
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
    String sql2 = "Update Members set User_Name ="+member.getUserName()+" where User_Name="+oldUserName;
    Statement pstm2 = conn.createStatement();
    pstm2.executeUpdate(sql2);
}}

