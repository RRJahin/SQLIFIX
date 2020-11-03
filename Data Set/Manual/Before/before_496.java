public class Dummy{
public static void insertCard(Connection conn, CreditCard card) throws SQLException {
    String sql = "Insert into Credit_Card(MemberID, Card_Number,ExpiryDate, CVV) values ("+ card.getId().toString()+","+card.getCardNumber()+","+card.getExpiryDate()+","+card.getCVV()+")";
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
}}

