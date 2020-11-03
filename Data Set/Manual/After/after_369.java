public class Dummy{
public static byte[] read(String table, String column, int id) {
    byte[] buffer = null;
    try {
        String query = "SELECT " + column + " FROM " + table + " WHERE id=?";
        java.sql.ResultSet rs = null;
        java.sql.PreparedStatement pstmt = null;
        pstmt = conn.prepareStatement(query);
        pstmt.setObject(1, id);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            buffer = rs.getBytes("image");
        }
    } catch (Exception e) {
        System.out.println("Read Error: " + e.getMessage());
    }
    return buffer;
}}

