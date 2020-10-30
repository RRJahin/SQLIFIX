public class Dummy{
public static int insertGuest(Connection conn, Guest guest) throws SQLException {
    String sql = "Insert into Guest(Guest_Name, Guest_Surname, Address, Email_Address, Card_Number, Phone_Number,ExpiryDate,CVV) values ("+guest.getGuestName()+","+guest.getGuestSurename()+","+guest.getGuestAddress()+","+guest.getGuestEmail()+","+guest.getGuestCardNumber()+","+guest.getGuestPhoneNumber()+","+guest.getExpiryDate()+","+guest.getCVV()+")";
    Statement pstm = conn.createStatement( Statement.RETURN_GENERATED_KEYS);
    pstm.executeUpdate(sql);
    ResultSet rs = pstm.getGeneratedKeys();
    int GuestID = 0;
    if (rs != null && rs.next()) {
        GuestID = rs.getInt(1);
    }
    return GuestID;
}}

