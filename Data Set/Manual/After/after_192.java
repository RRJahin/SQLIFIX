public class Dummy {
    public static void insertIntoJobFileTable(File file, NaeglingJob job, int type, int status) throws Exception {
        try {
            Connection conn = getDatabaseConnection();
            PreparedStatement s = conn.prepareStatement("INSERT INTO job_file_table VALUES(" + "'?'," + "'?'," + "'?'," + "?," + "?)");
            s.setObject(1, file.getName());
            s.setObject(2, job.getName());
            s.setObject(3, file.getAbsolutePath());
            s.setObject(4, type);
            s.setObject(5, status);
            s.executeUpdate();
            conn.close();
        } catch (Exception e) {
            throw new Exception("Error inserting into job_file_table.\n" + e.getMessage());
        }
    }
}
