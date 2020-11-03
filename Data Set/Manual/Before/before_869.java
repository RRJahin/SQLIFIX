public class Dummy{
public static VirtualMachineHost getHost(String hostname) throws Exception {
    try {
        VirtualMachineHost host = null;
        Connection conn = getDatabaseConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM virtual_machine_host_table WHERE hostname='" + hostname + "'");
        if (rs.next()) {
            host = new VirtualMachineHost(rs.getString("hostname"), rs.getString("ip"), rs.getString("naegling_port"));
        }
        conn.close();
        return host;
    } catch (Exception e) {
        throw new Exception("Error reading from virtual_machine_host_table.\n" + e.getMessage());
    }
}}

