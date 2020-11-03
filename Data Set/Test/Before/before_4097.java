class Dummy{
public static void writeNasdaqTicker(String ticker, String companyName) {
    Connection conn = null;
    try {
        String q = "INSERT INTO nasdaq(ticker,companyName) VALUES('" + ticker + "','" + companyName.replaceAll("'", "''") + "');";
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

