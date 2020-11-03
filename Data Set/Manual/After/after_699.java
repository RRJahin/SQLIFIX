public class Dummy{
public void progressUpdate(int ID, int newProgressResult) {
    String sql = "UPDATE tblAchievements SET fldProgress=? WHERE id=?;";
    try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setObject(1, newProgressResult);
        pstmt.setObject(2, ID);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}}

