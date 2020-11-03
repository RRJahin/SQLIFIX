class Dummy{
public static String[] getGatherTickers(int gatherRunID) {
    Connection conn = null;
    ArrayList<String> ar = new ArrayList<String>();
    final String cURL = "jdbc:mysql://192.168.5.12:3306/screener";
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(cURL, "screen", "password");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select i.ticker from interesting i WHERE " + "i.gather_runid=" + gatherRunID + " ORDER BY i.ticker;";
        ResultSet srs = stmt.executeQuery(sql);
        while (srs.next()) {
            String ticker = srs.getString("ticker").trim();
            ar.add(ticker);
            System.out.println(ticker);
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

