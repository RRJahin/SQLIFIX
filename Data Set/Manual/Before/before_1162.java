public class Dummy{
public static void updateMemberCreditCard(Connection conn, Starwood member, String oldNo) throws SQLException {
    String sql = "Update Starwood set Card_Number ="+member.getCardNumber()+"  where Id="+member.getId().toString();
    Statement pstm = conn.createStatement();
    String sql2 = "Update Credit_Card set Card_Number ="+member.getCardNumber()+"  where Card_Number="+oldNo;
    Statement pstm2 = conn.createStatement();
    pstm2.executeUpdate(sql2);
    pstm.executeUpdate(sql);
}}

