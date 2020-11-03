public class Dummy{
public static List<CreditCard> getCards(Connection conn, BigInteger id, String key) throws SQLException {
    String sql = "Select *  from Credit_Card a where a.MemberID = ?   ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, id.toString());
    ResultSet rs = pstm.executeQuery();
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

