public class Dummy{
public static void updateMemberPasword(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Members set User_Password ="+member.getPassword()+" where User_Name="+member.getUserName();
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
}}

