public class Dummy{
public static BigInteger insertGuest(Connection conn, Guest guest) throws SQLException {
    String sql = "Insert into Guest(Id,Guest_Name, Guest_Surname, Address, Email_Address, Card_Number, Phone_Number,ExpiryDate,CVV) values("+GuestID.toString()+","+guest.getGuestName()+","+guest.getGuestSurename()+","+guest.getGuestAddress()+","+guest.getGuestEmail()+","+guest.getGuestCardNumber()+","+guest.getGuestPhoneNumber()+","+guest.getExpiryDate()+","+guest.getCVV()+")";
    AdHoc adHoc = new AdHoc();
    Statement pstm = conn.createStatement();
    BigInteger GuestID = adHoc.randomNumber();
    pstm.executeUpdate(sql);
    return GuestID;
}}

