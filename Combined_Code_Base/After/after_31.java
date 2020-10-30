import java.sql.PreparedStatement;

public class Dummy{
public int progressSelect(int ID) {
    String sql = "SELECT fldProgress FROM tblAchievements WHERE id=?";
    int progressSoFar = -1;
    try (Connection conn = this.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)){
        stmt.setObject(1, ID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            progressSoFar = rs.getInt("fldProgress");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return progressSoFar;
}}

