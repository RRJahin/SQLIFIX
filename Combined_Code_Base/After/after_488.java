public class Dummy{
public static void updateMemberName(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Starwood set Member_Name =?  where Id=? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, member.getName());
    pstm.setObject(2, member.getId().toString());
    pstm.executeUpdate();
}}

