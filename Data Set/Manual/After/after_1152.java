public class Dummy{
public static void removeUser(Connection conn, Starwood member) throws SQLException {
    String username = member.getUserName();
    String sql = "Delete From Starwood where User_Name= ?";
    String sql2 = "Delete From Members where User_Name= ?";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, username);
    removeUserReservations(conn, member);
    removeCreditCards(conn, DB_members.getStarwoodMemberId(conn, username));
    pstm.executeUpdate();
    PreparedStatement pstm1 = conn.prepareStatement(sql2);
    pstm1.setObject(1, username);
    pstm1.executeUpdate();
}}

