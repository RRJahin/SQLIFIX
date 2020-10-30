public class Dummy{
public static VirtualSlaveNode getSlave(String domain) throws Exception {
    try {
        VirtualSlaveNode slave = null;
        Connection conn = getDatabaseConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM virtual_slave_node_table WHERE domain='" + domain + "'");
        if (rs.next()) {
            Statement s2 = conn.createStatement();
            ResultSet rs2 = s2.executeQuery("SELECT * FROM virtual_machine_host_table WHERE hostname='" + rs.getString("host") + "'");
            rs2.next();
            slave = new VirtualSlaveNode(rs.getString("cluster"), rs.getString("domain"), rs.getString("uuid"), rs.getString("bridge_mac"), rs.getString("bridge_network_interface"), rs.getString("hypervisor"), rs.getInt("ram_memory"), rs.getInt("cpu_quantity"), new VirtualMachineHost(rs2.getString("hostname"), rs2.getString("ip"), rs2.getString("naegling_port")), rs.getString("vnc_port"));
        }
        conn.close();
        return slave;
    } catch (Exception e) {
        throw new Exception("Error reading from database.\n" + e.getMessage());
    }
}}

