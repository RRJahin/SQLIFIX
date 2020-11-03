public class Dummy{
public void insert(String tableLabel, String fldAchievementTitle, int fldProgress, int fldBronzeGoal, int fldSilverGoal, int fldGoldGoal, String fldStatus) {
    String sql = "INSERT INTO " + tableLabel + " (fldAchievementTitle,fldProgress,fldBronzeGoal,fldSilverGoal,fldGoldGoal,fldStatus) VALUES("+fldAchievementTitle+","+fldProgress+","+fldBronzeGoal+","+fldSilverGoal+","+fldGoldGoal+","+fldStatus+")";
    try (Connection conn = this.connect();
        Statement pstmt = conn.createStatement()) {
        pstmt.executeUpdate(sql);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}}

