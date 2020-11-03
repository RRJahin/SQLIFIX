public class Dummy{
public static void insertIntoClusterTable(Cluster cluster) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        Statement s = conn.createStatement();
        s.executeUpdate("INSERT INTO cluster_table VALUES(" + "'" + cluster.getName() + "')");
        conn.close();
    } catch (Exception e) {
        throw new Exception("Error inserting into cluster_table.\n" + e.getMessage());
    }
}}

