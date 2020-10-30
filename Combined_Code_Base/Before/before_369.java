public class Dummy{
public static byte[] read(String table, String column, int id) {
    byte[] buffer = null;
    try {
        String query = "SELECT " + column + " FROM " + table + " WHERE id="+id;
        java.sql.ResultSet rs = null;
        java.sql.Statement pstmt = null;
        pstmt = conn.createStatement();
        rs = pstmt.executeQuery(query);
        while (rs.next()) {
            buffer = rs.getBytes("image");
        }
    } catch (Exception e) {
        System.out.println("Read Error: " + e.getMessage());
    }
    return buffer;
}}

