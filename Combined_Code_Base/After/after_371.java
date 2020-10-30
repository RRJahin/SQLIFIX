public class Dummy{
public static boolean update(String table, byte[] image, String column, int id) {
    boolean result = false;
    try {
        String query = "UPDATE " + table + " SET " + column + "=? WHERE id=" + id;
        java.sql.ResultSet rs = null;
        java.sql.PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement(query);
        pstmt.setBytes(1, image);
        pstmt.executeUpdate();
        System.out.println("Image saved to database successfully!");
        result = true;
    } catch (Exception e) {
        System.out.println("Read Error: " + e.getMessage());
    }
    return result;
}}

