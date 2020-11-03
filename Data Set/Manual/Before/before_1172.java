public class Dummy{
public static void insertMemberLogIn(Connection conn, Starwood member) throws SQLException {
    String sql = "Insert into Members(User_Name, User_Password) values ("+member.getUserName()+","+member.getPassword()+")";
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
}}

