public class Dummy{
public static void updateMemberPhoneNumber(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Starwood set Phone_Number =?  where Id=? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, member.getPhoneNumber());
    pstm.setObject(2, member.getId().toString());
    pstm.executeUpdate();
}}

