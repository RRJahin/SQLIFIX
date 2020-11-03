class Dummy{
private static void completeStalledRuns() {
    String unFinishedsql = "select gather_runid,marketid,last_completed_id from gather_runs where is_completed=0;";
    Connection conn = null;
    final String cURL = "jdbc:mysql://192.168.5.12:3306/screener";
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(cURL, "tmwsiy", "password");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet srs = stmt.executeQuery(unFinishedsql);
        while (srs.next()) {
            Integer gatherRunID = srs.getInt("gather_runid");
            Integer marketid = srs.getInt("marketid");
            Integer lastCompletedID = srs.getInt("last_completed_id");
            Screener.screenMarket(marketid, gatherRunID, lastCompletedID, true);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }
}}

