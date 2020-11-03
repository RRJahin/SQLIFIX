class Dummy{
public static void updateGatherRun(int gatherRunID, boolean isFinished, int lastCompleteIndex) {
    Connection conn = null;
    try {
        String q = "";
        if (isFinished)
            q = "UPDATE gather_runs SET is_completed=1,time_completed=now()  WHERE gather_runid=" + gatherRunID + ";";
        else
            q = "UPDATE gather_runs SET last_completed_id=" + lastCompleteIndex + "  WHERE gather_runid=" + gatherRunID + ";";
        final String cURL = "jdbc:mysql://192.168.5.12:3306/screener";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(cURL, "screen", "password");
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(q);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
}}

