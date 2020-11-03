public class Dummy{
public void deleteAchievement(int id) {
    String sql = "DELETE FROM tblAchievements WHERE id = "+id;
    try (Connection conn = this.connect();
        Statement pstmt = conn.createStatement()) {
        pstmt.executeUpdate(sql);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}}

