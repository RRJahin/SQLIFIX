public class Dummy{
public static int insertMember(Connection conn, Starwood member) throws SQLException {
    String sql = "Insert into Starwood(Member_Name, Member_Surname, Address, Email_Address, Card_Number, Phone_Number, User_Name) values ("+member.getName()+","+member.getSurename()+","+member.getAddress()+","+member.getEmail()+","+member.getCardNumber()+","+member.getPhoneNumber()+","+member.getUserName()+")";
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
    int ID = 0;
    ResultSet rs = pstm.getResultSet();
    if (rs != null && rs.next()) {
        ID = rs.getInt(1);
    }
    return ID;
}}

