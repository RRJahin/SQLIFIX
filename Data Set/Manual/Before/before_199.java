public class Dummy{
public static void deleteFromVirtualMasterNodeTable(String domain) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        Statement s = conn.createStatement();
        s.executeUpdate("DELETE FROM virtual_master_node_table where domain='" + domain + "'");
        conn.close();
    } catch (Exception e) {
        throw new Exception("Error deleting row from virtual_master_node_table.\n" + e.getMessage());
    }
}}

