public class Dummy{
public static String insertMember(Connection conn, Starwood member) throws SQLException {
    String output = null;
    BigInteger existingMember = getStarwoodMemberId(conn, member.getUserName());
    if (!existingMember.toString().equals(BigInteger.valueOf(-1).toString())) {
        System.out.println("hereyaah");
        output = "Username taken, please chose different username";
    } else {
        String sql = "Insert into Starwood(Id,Member_Name, Member_Surname, Address, Email_Address, Card_Number, Phone_Number, User_Name,CVV,ExpiryDate) values ("+adHoc.randomBigInteger().toString()+","+member.getName()+","+member.getSurename()+","+member.getAddress()+","+member.getEmail()+","+member.getCardNumber()+","+member.getPhoneNumber()+","+member.getUserName()+","+member.getCVV()+","+member.getExpiryDate());
        AdHoc adHoc = new AdHoc();
        Statement pstm = conn.createStatement();
        pstm.executeUpdate(sql);
    }
    return output;
}}

