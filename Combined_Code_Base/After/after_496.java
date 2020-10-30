public class Dummy{
public static void insertCard(Connection conn, CreditCard card) throws SQLException {
    String sql = "Insert into Credit_Card(MemberID, Card_Number,ExpiryDate, CVV) values (?,?,?,?)";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, card.getId().toString());
    pstm.setObject(2, card.getCardNumber());
    pstm.setObject(3, card.getExpiryDate());
    pstm.setObject(4, card.getCVV());
    pstm.executeUpdate();
}}

