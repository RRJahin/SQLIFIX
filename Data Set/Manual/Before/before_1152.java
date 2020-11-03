public class Dummy{
public static void removeUser(Connection conn, Starwood member) throws SQLException {
    String username = member.getUserName();
    String sql = "Delete From Starwood where User_Name= "+username;
    String sql2 = "Delete From Members where User_Name= "+username;
    Statement pstm = conn.createStatement();
    removeUserReservations(conn, member);
    removeCreditCards(conn, DB_members.getStarwoodMemberId(conn, username));
    pstm.executeUpdate(sql);
    Statement pstm1 = conn.createStatement();
    pstm1.executeUpdate(sql2);
}}

