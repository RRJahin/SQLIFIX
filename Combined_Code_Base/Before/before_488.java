public class Dummy{
public static void updateMemberName(Connection conn, Starwood member) throws SQLException {
    String sql = "Update Starwood set Member_Name ="+member.getName()+"  where Id="+member.getId().toString();
    Statement pstm = conn.createStatement();
    pstm.executeUpdate(sql);
}}

