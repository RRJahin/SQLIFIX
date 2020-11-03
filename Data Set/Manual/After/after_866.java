public class Dummy{
public static void deleteFromClusterTable(String name) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        PreparedStatement s = conn.prepareStatement("DELETE FROM cluster_table where name='?'");
        s.setObject(1,name);
        s.executeUpdate();
        conn.close();
    } catch (Exception e) {
        throw new Exception("Error deleting row from cluster_table.\n" + e.getMessage());
    }
}}

