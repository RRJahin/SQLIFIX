public class Dummy{
public static void deleteFromVirtualMachineHostTable(String hostname) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM virtual_slave_node_table WHERE host='" + hostname + "'");
        if (rs.next()) {
            conn.close();
            throw new Exception("Can not remove. Host is being used.");
        }
        rs = s.executeQuery("SELECT * FROM virtual_master_node_table WHERE host='" + hostname + "'");
        if (rs.next()) {
            conn.close();
            throw new Exception("Can not remove. Host is being used.");
        }
        s.executeUpdate("DELETE FROM virtual_machine_host_table where hostname='" + hostname + "'");
        conn.close();
    } catch (Exception e) {
        throw new Exception("Error deleting row from virtual_machine_host_table.\n" + e.getMessage());
    }
}}

