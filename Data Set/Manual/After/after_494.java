public class Dummy{
public static void updateMemberUsername(Connection conn, Starwood member, String oldUserName) throws SQLException {
    String sql = "Update Starwood set User_Name =?  where Id=? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, member.getUserName());
    pstm.setObject(2, member.getId().toString());
    pstm.executeUpdate();
    String sql2 = "Update Members set User_Name =? where User_Name=? ";
    PreparedStatement pstm2 = conn.prepareStatement(sql2);
    pstm2.setObject(1, member.getUserName());
    pstm2.setObject(2, oldUserName);
    pstm2.executeUpdate();
}}

