public class Dummy{
public static Starwood removeCard(Connection conn, Starwood member, BigInteger id, String cardToRemove, String key) throws SQLException {
    String sql = "Select *  from Credit_Card a where a.MemberID = "+id.toString();
    Statement pstm = conn.createStatement();
    ResultSet rs = pstm.executeQuery(sql);
    while (rs.next()) {
        String card = rs.getString(1);
        String update = card;
        CreditCard creditCard;
        try {
            creditCard = new CreditCard(EncryptDecrypt.decrypt(card, key), id);
            boolean found = false;
            if (isEqual(creditCard.getCardNumber().toString(), cardToRemove)) {
                found = true;
                card = creditCard.getCardNumber();
            }
            if (found) {
                sql = "Delete From Credit_Card where Card_Number = ?";
                pstm = conn.createStatement(sql);
                pstm.setString(1, rs.getString(1));
                pstm.executeUpdate();
            } else {
                sql = "Update Starwood set Card_Number =?  where Id=? ";
                pstm = conn.createStatement(sql);
                System.out.println("update star");
                pstm.setString(1, update);
                pstm.setString(2, id.toString());
                member.setCardNumber(creditCard.getCardNumber());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return member;
}}

