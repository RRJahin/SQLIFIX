public class Dummy{
public static void deleteFromClusterTable(String name) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        Statement s = conn.createStatement();
        s.executeUpdate("DELETE FROM cluster_table where name='" + name + "'");
        conn.close();
    } catch (Exception e) {
        throw new Exception("Error deleting row from cluster_table.\n" + e.getMessage());
    }
}}

