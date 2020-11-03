public class Dummy{
public static void updateMemberEmail(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Starwood set Email_Address =?  where Id=? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, member.getEmail());
    pstm.setObject(2, member.getId().toString());
    pstm.executeUpdate();
}}

