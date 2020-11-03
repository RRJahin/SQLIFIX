public class Dummy{
public static void deleteFromVirtualMasterNodeTable(String domain) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        PreparedStatement s = conn.prepareStatement("DELETE FROM virtual_master_node_table where domain='?'");
        s.setObject(1,domain);
        s.executeUpdate();
        conn.close();
    } catch (Exception e) {
        throw new Exception("Error deleting row from virtual_master_node_table.\n" + e.getMessage());
    }
}}

