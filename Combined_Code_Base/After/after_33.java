public class Dummy{
public void deleteAchievement(int id) {
    String sql = "DELETE FROM tblAchievements WHERE id = ?";
    try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setObject(1, id);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}}

