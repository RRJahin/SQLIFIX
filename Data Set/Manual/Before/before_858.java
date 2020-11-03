public class Dummy{
public static void insertIntoVirtualMachineHostTable(VirtualMachineHost host) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        Statement s = conn.createStatement();
        s.executeUpdate("INSERT INTO virtual_machine_host_table VALUES(" + "'" + host.getHostName() + "'," + "'" + host.getIp() + "'," + "'" + host.getNaeglingPort() + "')");
        conn.close();
    } catch (Exception e) {
        throw new Exception("Error inserting into virtual_machine_host_table.\n" + e.getMessage());
    }
}}

