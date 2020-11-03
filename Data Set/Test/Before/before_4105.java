class Dummy{
public static Stock getData(String ticker, int marketid, int gatherRunID, NumberFormat nf, boolean updateWithData) throws Exception {
    Stock s = new Stock(ticker);
    String page = UC.getPage("http://finance.yahoo.com/q/ks?s=" + s.getTicker());
    if (page.contains("There is no  data available for " + s.getTicker()) || page.contains("<title>Invalid Ticker Symbol") || page.contains("There are no All Markets results for") || page.contains("<title>Symbol Lookup")) {
        return new Stock("nodata");
    } else {
        if (updateWithData) {
            Connection conn = null;
            try {
                String q = "INSERT INTO withdata(gather_runid,marketid,dateObserved,ticker) VALUES(" + gatherRunID + "," + marketid + ",now(),'" + s.getTicker() + "');";
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
        }
    }
    Pattern patt = Pattern.compile("Qtrly\\s+Revenue\\s+Growth\\s+.{6}</td><td class=\"yfnc_tabledata1\">([^<]+)");
    Matcher m = patt.matcher(page);
    if (m.find()) {
        String data = m.group(1);
        if (data.contains("N/A") || data.contains("Na") || data.contains("NA") || data.length() == 0)
            return new Stock("nodata");
        s.setQtrlyRevGrowth(nf.parse(data.substring(0, data.length() - 1)).doubleValue());
    } else {
    }
    patt = Pattern.compile("Qtrly\\s+Earnings\\s+Growth\\s+.{6}</td><td class=\"yfnc_tabledata1\">([^<]+)");
    m = patt.matcher(page);
    if (m.find()) {
        String data = m.group(1);
        if (data.contains("N/A") || data.contains("Na") || data.contains("NA") || data.length() == 0)
            return new Stock("nodata");
        s.setQtrlyEarningsGrowth(nf.parse(data.substring(0, data.length() - 1)).doubleValue());
    } else {
    }
    patt = Pattern.compile("Operating\\s+Cash\\s+Flow\\s+.{6}</td><td class=\"yfnc_tabledata1\">([^<]+)");
    m = patt.matcher(page);
    if (m.find()) {
        String data = m.group(1);
        if (data.contains("N/A") || data.contains("Na") || data.contains("NA") || data.length() == 0)
            return new Stock("nodata");
        double val = 0;
        if (!data.equals("0"))
            val = nf.parse(data.substring(0, data.length() - 1)).doubleValue();
        if (data.endsWith("M"))
            val *= 1000000;
        if (data.endsWith("B"))
            val *= 1000000000;
        s.setOperatingCashFlow(val);
    } else {
    }
    patt = Pattern.compile("Shares\\s+Outstanding<font size=\"-1\"><sup>5</sup></font>:</td><td class=\"yfnc_tabledata1\">([^<]+)");
    m = patt.matcher(page);
    if (m.find()) {
        String data = m.group(1);
        if (data.contains("N/A") || data.contains("Na") || data.contains("NA") || data.length() == 0)
            return new Stock("nodata");
        double val = 0;
        if (!data.equals("0"))
            val = nf.parse(data.substring(0, data.length() - 1)).doubleValue();
        if (data.endsWith("M"))
            val *= 1000000;
        if (data.endsWith("B"))
            val *= 1000000000;
        s.setSharesOutstanding(val);
    } else {
    }
    patt = Pattern.compile("Held by Institutions<font size=\"-1\"><sup>1</sup></font>:</td><td class=\"yfnc_tabledata1\">([^<]+)");
    m = patt.matcher(page);
    if (m.find()) {
        String data = m.group(1);
        if (data.contains("N/A") || data.contains("Na") || data.contains("NA") || data.length() == 0)
            return new Stock("nodata");
        s.setPercentHeldByInstitutions(nf.parse(data.substring(0, data.length() - 1)).doubleValue());
    } else {
    }
    page = UC.getPage("http://finance.yahoo.com/q?s=" + s.getTicker());
    patt = Pattern.compile("Prev\\s+Close:</th><td\\s+class=\"yfnc_tabledata1\">([^<]+)");
    m = patt.matcher(page);
    if (m.find()) {
        String data = m.group(1);
        if (data.contains("N/A") || data.contains("Na") || data.contains("NA") || data.length() == 0)
            return new Stock("nodata");
        s.setCurrentQuote(nf.parse(data).doubleValue());
    } else {
    }
    return s;
}}

