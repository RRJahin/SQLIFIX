public class Dummy{
public static void updateMemberSurname(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Starwood set Member_Surname =?  where Id=? ";
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setObject(1, member.getSurename());
    pstm.setObject(2, member.getId().toString());
    pstm.executeUpdate();
}}

