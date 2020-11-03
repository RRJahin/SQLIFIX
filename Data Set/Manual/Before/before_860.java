public class Dummy{
public static void insertIntoJobTable(NaeglingJob job) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        Statement s = conn.createStatement();
        s.executeUpdate("INSERT INTO job_table VALUES(" + "'" + job.getName() + "'," + "'" + job.getCluster() + "'," + +job.getStatus() + ")");
        conn.close();
    } catch (Exception e) {
        throw new Exception("Error inserting into job_table.\n" + e.getMessage());
    }
}}

