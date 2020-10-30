public class Dummy{
public static void updateMemberPasword(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Members set User_Password =? where User_Name=? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, member.getPassword());
    pstm.setObject(2, member.getUserName());
    pstm.executeUpdate();
}}

