public class Dummy{
public static int insertGuest(Connection conn, Guest guest) throws SQLException {
    String sql = "Insert into Guest(Guest_Name, Guest_Surname, Address, Email_Address, Card_Number, Phone_Number,ExpiryDate,CVV) values (?,?,?,?,?,?,,)";
    PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    pstm.setObject(1, guest.getGuestName());
    pstm.setObject(2, guest.getGuestSurename());
    pstm.setObject(3, guest.getGuestAddress());
    pstm.setObject(4, guest.getGuestEmail());
    pstm.setObject(5, guest.getGuestCardNumber());
    pstm.setObject(6, guest.getGuestPhoneNumber());
    pstm.setObject(7, guest.getExpiryDate());
    pstm.setObject(8, guest.getCVV());
    pstm.executeUpdate();
    ResultSet rs = pstm.getGeneratedKeys();
    int GuestID = 0;
    if (rs != null && rs.next()) {
        GuestID = rs.getInt(1);
    }
    return GuestID;
}}

