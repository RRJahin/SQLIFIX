public class Dummy{
private static void removeCreditCards(Connection conn, BigInteger id) throws SQLException {
    String sql = "Delete From Credit_Card where MemberID = ?";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, id.toString());
    pstm.executeUpdate();
}}

