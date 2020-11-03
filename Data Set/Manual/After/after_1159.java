public class Dummy{
public static void updateMemberAddress(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Starwood set Address =?  where Id=? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, member.getAddress());
    pstm.setObject(2, member.getId().toString());
    pstm.executeUpdate();
}}

