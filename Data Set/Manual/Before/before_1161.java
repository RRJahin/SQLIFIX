public class Dummy{
public static void updateMemberPhoneNumber(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Starwood set Phone_Number ="+member.getPhoneNumber()+"  where Id="+member.getId().toString();
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
}}

