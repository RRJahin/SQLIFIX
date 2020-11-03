class Dummy{
public static String getGatherRunInterestingDataRows(int gatherRunID) {
    Connection conn = null;
    String pattern = "yyyy.MM.dd 'at' HH:mm:ss z";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    final String cURL = "jdbc:mysql://192.168.5.12:3306/screener";
    StringBuffer output = new StringBuffer();
    output.append("\"Market Name\",\"Ticker\",\"Company Name\",\"Interactive Chart\",\"Date Pulled\"\n");
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(cURL, "screen", "password");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select m.marketName,i.ticker,t.companyName,i.dateObserved from interesting i " + "inner join gather_runs gr on gr.gather_runid=i.gather_runid " + "inner join markets m on m.marketid=gr.marketid " + "INNER JOIN tickers t on t.ticker=i.ticker " + "WHERE " + "i.gather_runid=" + gatherRunID + " ORDER BY i.ticker;";
        ResultSet srs = stmt.executeQuery(sql);
        while (srs.next()) {
            String marketName = srs.getString("marketName").trim();
            String ticker = srs.getString("ticker").trim();
            String companyName = srs.getString("companyName").trim();
            Timestamp dateObserved = srs.getTimestamp("dateObserved");
            output.append("\"" + marketName + "\",\"" + ticker + "\",\"" + companyName + "\",\"http://finance.yahoo.com/echarts?s=CPK+Interactive#symbol=" + ticker + "\",\"" + sdf.format(dateObserved) + "\"\n");
            System.out.print("\"" + marketName + "\",\"" + ticker + "\",\"" + companyName + "\",\"http://finance.yahoo.com/echarts?s=CPK+Interactive#symbol=" + ticker + "\",\"" + sdf.format(dateObserved) + "\"\n");
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
    return output.toString();
}}

