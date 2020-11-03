class Dummy{
public static String[] getSymbolsForGatherRun(int gatherRunID, boolean onlyWithData) {
    Connection conn = null;
    final String cURL = "jdbc:mysql://192.168.5.12:3306/screener";
    ArrayList<String> ar = new ArrayList<String>();
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(cURL, "screen", "password");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet srs = null;
        if (onlyWithData)
stmt = conn.createStatement();
            srs = stmt.executeQuery("SELECT tickers.ticker FROM tickers INNER JOIN gather_runs on gather_runs.marketid=tickers.marketid WHERE gather_runs.gather_runid=" + gatherRunID + " AND tickers.ticker IN (SELECT withdata.ticker FROM withdata INNER JOIN gather_runs on withdata.marketid=gather_runs.marketid WHERE gather_runs.gather_runid=" + gatherRunID + ");");
        else
            srs = stmt.executeQuery("SELECT t.ticker FROM tickers t INNER JOIN gather_runs grs on t.marketid=grs.marketid WHERE grs.gather_runid=" + gatherRunID);
        while (srs.next()) {
            String name = srs.getString("ticker");
            ar.add(name);
            System.out.println(name);
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
    return (String[]) ar.toArray(new String[ar.size()]);
}}

