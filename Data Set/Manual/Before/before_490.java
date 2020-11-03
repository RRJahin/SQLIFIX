public class Dummy{
public static void updateMemberAddress(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Starwood set Address ="+member.getAddress()+"  where Id="+member.getId().toString();
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
}}

