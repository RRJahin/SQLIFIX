public class Dummy{
public static void updateMemberEmail(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Starwood set Email_Address ="+member.getEmail()+"  where Id="+member.getId().toString();
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
}}

