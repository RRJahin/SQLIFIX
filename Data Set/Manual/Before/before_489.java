public class Dummy{
public static void updateMemberSurname(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Starwood set Member_Surname = "+member.getSurename()+"  where Id= "+member.getId().toString();
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
}}

