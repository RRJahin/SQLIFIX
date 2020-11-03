public class Dummy{
public int progressSelect(int ID) {
    String sql = "SELECT fldProgress FROM tblAchievements WHERE id=" + ID;
    int progressSoFar = -1;
    try (Connection conn = this.connect();
        Statement stmt = conn.createStatement()){
        ResultSet rs = stmt.executeQuery(sql) ;
        while (rs.next()) {
            progressSoFar = rs.getInt("fldProgress");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return progressSoFar;
}}

