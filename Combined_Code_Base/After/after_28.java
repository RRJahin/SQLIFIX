public class Dummy{
public void insert(String tableLabel, String fldAchievementTitle, int fldProgress, int fldBronzeGoal, int fldSilverGoal, int fldGoldGoal, String fldStatus) {
    String sql = "INSERT INTO " + tableLabel + " (fldAchievementTitle,fldProgress,fldBronzeGoal,fldSilverGoal,fldGoldGoal,fldStatus) VALUES(?,?,?,?,?,?)";
    try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setObject(1, fldAchievementTitle);
        pstmt.setObject(2, fldProgress);
        pstmt.setObject(3, fldBronzeGoal);
        pstmt.setObject(4, fldSilverGoal);
        pstmt.setObject(5, fldGoldGoal);
        pstmt.setObject(6, fldStatus);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}}

