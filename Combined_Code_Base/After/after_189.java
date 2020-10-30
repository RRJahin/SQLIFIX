public class Dummy {
    public static void insertIntoVirtualMachineHostTable(VirtualMachineHost host) throws Exception {
        try {
            Connection conn = getDatabaseConnection();
            PreparedStatement s = conn.prepareStatement("INSERT INTO virtual_machine_host_table VALUES(" + "'?'," + "'?'," + "'?')");
            s.setObject(1, host.getHostName());
            s.setObject(2, host.getIp());
            s.setObject(3, host.getNaeglingPort());
            s.executeUpdate();
            conn.close();
        } catch (Exception e) {
            throw new Exception("Error inserting into virtual_machine_host_table.\n" + e.getMessage());
        }
    }
}
