public class Dummy{
public static String insertMember(Connection conn, Starwood member) throws SQLException {
    String output = null;
    BigInteger existingMember = getStarwoodMemberId(conn, member.getUserName());
    if (!existingMember.toString().equals(BigInteger.valueOf(-1).toString())) {
        System.out.println("hereyaah");
        output = "Username taken, please chose different username";
    } else {
        String sql = "Insert into Starwood(Id,Member_Name, Member_Surname, Address, Email_Address, Card_Number, Phone_Number, User_Name,CVV,ExpiryDate) values (?,?,?,?,?,?,?,?,?,?)";
        AdHoc adHoc = new AdHoc();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, adHoc.randomBigInteger().toString());
        pstm.setObject(2, member.getName());
        pstm.setObject(3, member.getSurename());
        pstm.setObject(4, member.getAddress());
        pstm.setObject(5, member.getEmail());
        pstm.setObject(6, member.getCardNumber());
        pstm.setObject(7, member.getPhoneNumber());
        pstm.setObject(8, member.getUserName());
        pstm.setObject(9, member.getCVV());
        pstm.setObject(10, member.getExpiryDate());
        pstm.executeUpdate();
    }
    return output;
}}

