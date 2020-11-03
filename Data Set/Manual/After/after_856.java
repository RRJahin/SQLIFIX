public class Dummy {
    public static void insertIntoClusterTable(Cluster cluster) throws Exception {
        try {
            Connection conn = getDatabaseConnection();
            PreparedStatement s = conn.prepareStatement("INSERT INTO cluster_table VALUES(" + "'?')");
            s.setObject(1, cluster.getName());
            s.executeUpdate();

            conn.close();
        } catch (Exception e) {
            throw new Exception("Error inserting into cluster_table.\n" + e.getMessage());
        }
    }
}
