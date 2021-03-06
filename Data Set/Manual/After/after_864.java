public class Dummy{
public static VirtualMasterNode getMaster(String domain) throws Exception {
    try {
        VirtualMasterNode master = null;
        Connection conn = getDatabaseConnection();
        PreparedStatement s = conn.prepareStatement("SELECT * FROM virtual_master_node_table WHERE domain='?'");
        s.setObject(1,domain);
        ResultSet rs = s.executeQuery();
        if (rs.next()) {
            Statement s2 = conn.createStatement();
            ResultSet rs2 = s2.executeQuery("SELECT * FROM virtual_machine_host_table WHERE hostname='" + rs.getString("host") + "'");
            rs2.next();
            master = new VirtualMasterNode(rs.getString("cluster"), rs.getString("domain"), rs.getString("template"), rs.getString("vdisk_path"), rs.getString("uuid"), rs.getString("bridge_mac"), rs.getString("bridge_network_interface"), rs.getString("vir_naegling_mac"), rs.getString("hypervisor"), rs.getInt("ram_memory"), rs.getInt("cpu_quantity"), new VirtualMachineHost(rs2.getString("hostname"), rs2.getString("ip"), rs2.getString("naegling_port")), rs.getString("vnc_port"));
        }
        conn.close();
        return master;
    } catch (Exception e) {
        throw new Exception("Error reading from database.\n" + e.getMessage());
    }
}}

