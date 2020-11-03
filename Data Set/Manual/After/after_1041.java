public class Dummy{
public static void insertBlob(String table, String filename, String desc) {
    String query = "INSERT INTO " + table + " VALUES('', ? , ? " + ")";
    try (java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setBytes(1, readFile(filename));
        pstmt.setObject(2, desc);
        pstmt.executeUpdate();
        System.out.println("Stored the file in the BLOB column.");
    } catch (java.sql.SQLException e) {
        System.out.println(e.getMessage());
    }
}}

