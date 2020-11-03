public class Dummy{
public static Starwood findStarwoodMember(Connection conn, BigInteger id) throws SQLException {
    String sql = "Select *  from Starwood a " + " where a.id = "+id.toString();
    Statement pstm = conn.createStatement();
    ResultSet rs = pstm.executeQuery(sql);
    if (rs.next()) {
        String userName = rs.getString("User_Name");
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

