public class Dummy{
public static void updateMemberCreditCard(Connection conn, Starwood member, String oldNo) throws SQLException {
    String sql = "Update Starwood set Card_Number =?  where Id=? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, member.getCardNumber());
    pstm.setObject(2, member.getId().toString());
    String sql2 = "Update Credit_Card set Card_Number =?  where Card_Number=? ";
    PreparedStatement pstm2 = conn.prepareStatement(sql2);
    pstm2.setObject(1, member.getCardNumber());
    pstm2.setObject(2, oldNo);
    pstm2.executeUpdate();
    pstm.executeUpdate();
}}

