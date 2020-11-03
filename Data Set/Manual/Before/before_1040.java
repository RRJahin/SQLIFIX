public class Dummy{
public static boolean update(String table, byte[] image, String column, int id) {
    boolean result = false;
    try {
        String query = "UPDATE " + table + " SET " + column + "="+image+" WHERE id=" + id;
        java.sql.ResultSet rs = null;
        java.sql.Statement pstmt = null;
        pstmt = conn.createStatement();
        pstmt.executeUpdate(query);
        System.out.println("Image saved to database successfully!");
        result = true;
    } catch (Exception e) {
        System.out.println("Read Error: " + e.getMessage());
    }
    return result;
}}

