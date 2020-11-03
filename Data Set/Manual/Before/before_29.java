public class Dummy{
public void stateUpdate(int editIDResult, String editAchievementStatus) {
    String sql = "UPDATE tblAchievements SET fldStatus="+editAchievementStatus+" WHERE id="+editIDResult+";";
    try (Connection conn = this.connect();
        Statement pstmt = conn.createStatement()) {
        pstmt.executeUpdate(sql);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}}

