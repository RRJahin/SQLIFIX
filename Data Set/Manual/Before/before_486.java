public class Dummy{
public static List<CreditCard> getCards(Connection conn, BigInteger id, String key) throws SQLException {
    String sql = "Select *  from Credit_Card a where a.MemberID = "+id.toString();
    Statement pstm = conn.createStatement(sql);
    ResultSet rs = pstm.executeQuery(sql);
    List<CreditCard> list = new ArrayList<CreditCard>();
    while (rs.next()) {
        String card = rs.getString(1);
        CreditCard creditCard;
        try {
            creditCard = new CreditCard(EncryptDecrypt.decrypt(card, key), id);
            list.add(creditCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return list;
}}

