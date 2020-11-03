public class Dummy {
public static void insertIntoJobTable(NaeglingJob job) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        PreparedStatement s = conn.prepareStatement("INSERT INTO job_table VALUES(" + "'?'," + "'?',?)");
        s.setObject(1,job.getName());
        s.setObject(2,job.getCluster());
        s.setObject(3,job.getStatus());
        s.executeUpdate();
        conn.close();
 
 
    }
}}

