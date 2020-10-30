public class Dummy{
public static void insertMemberLogIn(Connection conn, Starwood member) throws SQLException {
    String sql = "Insert into Members(User_Name, User_Password) values (?,?)";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, member.getUserName());
    pstm.setObject(2, member.getPassword());
    pstm.executeUpdate();
}}

