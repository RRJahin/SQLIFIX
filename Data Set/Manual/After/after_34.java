public class Dummy{
public ObservableList<Achievement> getAchievementForOverview() {
    ObservableList<Achievement> achievement = FXCollections.observableArrayList();
    String sql = "SELECT * FROM tblAchievements WHERE fldStatus='Active'";
    try (Connection conn = this.connect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            String achievementResult = rs.getString("fldAchievementTitle");
            int progressResult = rs.getInt("fldProgress");
            int bronzeResult = rs.getInt("fldBronzeGoal");
            int silverResult = rs.getInt("fldSilverGoal");
            int goldResult = rs.getInt("fldGoldGoal");
            achievement.add(new Achievement(achievementResult, progressResult, bronzeResult, silverResult, goldResult));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return achievement;
}}

