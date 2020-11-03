public class Dummy{
public static BigInteger insertGuest(Connection conn, Guest guest) throws SQLException {
    String sql = "Insert into Guest(Id,Guest_Name, Guest_Surname, Address, Email_Address, Card_Number, Phone_Number,ExpiryDate,CVV) values (?,?,?,?,?,?,?,?,?)";
    AdHoc adHoc = new AdHoc();
    PreparedStatement pstm = conn.prepareStatement(sql);
    BigInteger GuestID = adHoc.randomNumber();
    pstm.setObject(1, GuestID.toString());
    pstm.setObject(2, guest.getGuestName());
    pstm.setObject(3, guest.getGuestSurename());
    pstm.setObject(4, guest.getGuestAddress());
    pstm.setObject(5, guest.getGuestEmail());
    pstm.setObject(6, guest.getGuestCardNumber());
    pstm.setObject(7, guest.getGuestPhoneNumber());
    pstm.setObject(8, guest.getExpiryDate());
    pstm.setObject(9, guest.getCVV());
    pstm.executeUpdate();
    return GuestID;
}}

