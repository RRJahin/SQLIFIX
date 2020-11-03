public class Dummy{
private static void removeCreditCards(Connection conn, BigInteger id) throws SQLException {
    String sql = "Delete From Credit_Card where MemberID = "+id.toString();
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
}}

