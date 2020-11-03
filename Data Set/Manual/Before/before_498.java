public class Dummy{
public static Guest QueryGuest(Connection conn, BigInteger GuestID) throws SQLException {
    String sql = "Select a.Guest_Name, a.Guest_Surname, a.Address, a.Card_Number, a.Phone_Number, a.Email_Address, a.CVV, a.ExpiryDate from Guest a WHERE Id = ?";
    Statement pstm = conn.createStatement(sql);
    pstm.setString(1, GuestID.toString());
    ResultSet rs = pstm.executeQuery();
    if (rs.next()) {
        String Guest_Name = rs.getString("Guest_Name");
        String Guest_Surname = rs.getString("Guest_Surname");
        String Address = rs.getString("Address");
        String Card_Number = rs.getString("Card_Number");
        int Phone_Number = rs.getInt("Phone_Number");
        String Email_Address = rs.getString("Email_Address");
        Guest guest = new Guest(Guest_Name, Guest_Surname, Address, Email_Address, Card_Number, Phone_Number);
        guest.setGuestID(GuestID);
        return guest;
    }
    return null;
}}

