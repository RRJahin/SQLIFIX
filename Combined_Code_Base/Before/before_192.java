public class Dummy{
public static void insertIntoJobFileTable(File file, NaeglingJob job, int type, int status) throws Exception {
    try {
        Connection conn = getDatabaseConnection();
        Statement s = conn.createStatement();
        s.executeUpdate("INSERT INTO job_file_table VALUES(" + "'" + file.getName() + "'," + "'" + job.getName() + "'," + "'" + file.getAbsolutePath() + "'," + "" + type + "," + "" + status + ")");
        conn.close();
    } catch (Exception e) {
        throw new Exception("Error inserting into job_file_table.\n" + e.getMessage());
    }
}}

