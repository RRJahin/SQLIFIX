public class Dummy{
public void stateUpdate(int editIDResult, String editAchievementStatus) {
    String sql = "UPDATE tblAchievements SET fldStatus=? WHERE id=?;";
    try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setObject(1, editAchievementStatus);
        pstmt.setObject(2, editIDResult);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}}

