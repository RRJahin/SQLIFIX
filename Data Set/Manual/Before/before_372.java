public class Dummy{
public static void insertBlob(String table, String filename, String desc) {
    String query = "INSERT INTO " + table + " VALUES('', "+readFile(filename)+" , "+desc+" " + ")";
    try (java.sql.Statement pstmt = conn.createStatement()) {
        pstmt.executeUpdate(query);
        System.out.println("Stored the file in the BLOB column.");
    } catch (java.sql.SQLException e) {
        System.out.println(e.getMessage());
    }
}}

