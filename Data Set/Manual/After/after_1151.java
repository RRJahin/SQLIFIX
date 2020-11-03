public class Dummy{
public static int insertMember(Connection conn, Starwood member) throws SQLException {
    String sql = "Insert into Starwood(Member_Name, Member_Surname, Address, Email_Address, Card_Number, Phone_Number, User_Name) values (?,?,?,?,?,?,?)";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, member.getName());
    pstm.setObject(2, member.getSurename());
    pstm.setObject(3, member.getAddress());
    pstm.setObject(4, member.getEmail());
    pstm.setObject(5, member.getCardNumber());
    pstm.setObject(6, member.getPhoneNumber());
    pstm.setObject(7, member.getUserName());
    pstm.executeUpdate();
    int ID = 0;
    ResultSet rs = pstm.getResultSet();
    if (rs != null && rs.next()) {
        ID = rs.getInt(1);
    }
    return ID;
}}

