public class Dummy{
public static void deleteFromVirtualMachineHostTable(String hostname) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        PreparedStatement s = conn.prepareStatement("SELECT * FROM virtual_slave_node_table WHERE host='?'");
        s.setObject(1,hostname);
        ResultSet rs = s.executeQuery();
        if (rs.next()) {
            conn.close();
            throw new Exception("Can not remove. Host is being used.");
        }
        s = conn.prepareStatement("SELECT * FROM virtual_master_node_table WHERE host='?'");
        s.setObject(1,hostname);
        rs = s.executeQuery();
        if (rs.next()) {
            conn.close();
            throw new Exception("Can not remove. Host is being used.");
        }
        s = conn.prepareStatement("DELETE FROM virtual_machine_host_table where hostname='?'");
        s.setObject(1,hostname);
        s.executeUpdate();
        conn.close();
    } catch (Exception e) {
        throw new Exception("Error deleting row from virtual_machine_host_table.\n" + e.getMessage());
    }
}}

