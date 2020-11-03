public class Dummy{
public static VirtualMachineHost getHost(String hostname) throws Exception {
    try {
        VirtualMachineHost host = null;
        Connection conn = getDatabaseConnection();
        PreparedStatement s = conn.prepareStatement("SELECT * FROM virtual_machine_host_table WHERE hostname='?'");
        s.setObject(1,hostname);
        ResultSet rs = s.executeQuery();
        if (rs.next()) {
            host = new VirtualMachineHost(rs.getString("hostname"), rs.getString("ip"), rs.getString("naegling_port"));
        }
        conn.close();
        return host;
    } catch (Exception e) {
        throw new Exception("Error reading from virtual_machine_host_table.\n" + e.getMessage());
    }
}}

