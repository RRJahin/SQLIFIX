public class Dummy{
public static Starwood findStarwoodMember(Connection conn, String userName) throws SQLException {
    String sql = "Select *  from Starwood a " + " where a.User_Name = ? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, userName);
    ResultSet rs = pstm.executeQuery();
    if (rs.next()) {
        String name = rs.getString("Member_Name");
        String surname = rs.getString("Member_Surname");
        String address = rs.getString("Address");
        String email = rs.getString("Email_Address");
        String cardNumber = rs.getString("Card_Number");
        String phoneNumber = Integer.toString(rs.getInt("Phone_Number"));
        int PhoneNumber = Integer.parseInt(phoneNumber);
        Starwood member = new Starwood();
        member.setUserName(userName);
        member.setName(name);
        member.setAddress(address);
        member.setCardNumber(cardNumber);
        member.setSurename(surname);
        member.setEmail(email);
        member.setPhoneNumber(PhoneNumber);
        return member;
    }
    return null;
}}

