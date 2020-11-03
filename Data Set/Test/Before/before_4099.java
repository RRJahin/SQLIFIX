class Dummy{
public static GatherRunResult getGatherRunResult(int gatherRunID) {
    String csv = getGatherRunInterestingDataRows(gatherRunID);
    String data = getGatherRunDataRows(gatherRunID);
    Connection conn = null;
    String marketName = "";
    Integer marketID = null;
    final String cURL = "jdbc:mysql://192.168.5.12:3306/screener";
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(cURL, "screen", "password");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select m.marketName,m.marketid from gather_runs gr " + "inner join markets m on m.marketid=gr.marketid " + "where gather_runid=" + gatherRunID + ";";
        ResultSet srs = stmt.executeQuery(sql);
        if (srs.next()) {
            marketName = srs.getString("marketName");
            marketID = srs.getInt("marketid");
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
    return new GatherRunResult(gatherRunID, marketID.intValue(), marketName, csv, getGatherTickers(gatherRunID));
}}

