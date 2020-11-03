public class Dummy{
public void handleResponse(final HttpResponse response, final HttpContext context) {
    HttpEntity entity = response.getEntity();
    NumberFormat nf = NumberFormat.getInstance();
    String ticker = "";
    try {
        Header[] headers = response.getAllHeaders();
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].getName().equals("Set-Cookie") && headers[i].getValue().startsWith("PRF")) {
                Pattern patt = Pattern.compile("PRF=&t=([^;]+)");
                Matcher m = patt.matcher(headers[i].getValue());
                if (m.find())
                    ticker = m.group(1);
            }
        }
        if (ticker.length() > 0) {
            Connection conn = null;
            try {
                ResultSet rst = null;
                String q = "INSERT INTO withdata(dateObserved,ticker) VALUES(now(),'" + ticker + "');";
                final String cURL = "jdbc:mysql://192.168.5.12:3306/screener";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(cURL, "tmwsiy", "password");
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
        } else {
            return;
        }
        System.out.println("ticker: " + ticker);
        String page = EntityUtils.toString(entity);
        Stock s = new Stock(ticker);
        if (page.contains("There is no  data available for ") || page.contains("<title>Invalid Ticker Symbol") || page.contains("There are no All Markets results for") || page.contains("<title>Symbol Lookup"))
            return;
        Pattern patt = Pattern.compile("Qtrly\\s+Revenue\\s+Growth\\s+.{6}</td><td class=\"yfnc_tabledata1\">([^<]+)");
        Matcher m = patt.matcher(page);
        if (m.find()) {
            String data = m.group(1);
            if (data.contains("N/A"))
                return;
            try {
                s.setQtrlyRevGrowth(nf.parse(data.substring(0, data.length() - 1)).doubleValue());
            } catch (Exception e) {
                return;
            }
        } else {
            return;
        }
        patt = Pattern.compile("Qtrly\\s+Earnings\\s+Growth\\s+.{6}</td><td class=\"yfnc_tabledata1\">([^<]+)");
        m = patt.matcher(page);
        if (m.find()) {
            String data = m.group(1);
            if (data.contains("N/A"))
                return;
            try {
                s.setQtrlyEarningsGrowth(nf.parse(data.substring(0, data.length() - 1)).doubleValue());
            } catch (Exception e) {
                return;
            }
        } else {
            return;
        }
        patt = Pattern.compile("Operating\\s+Cash\\s+Flow\\s+.{6}</td><td class=\"yfnc_tabledata1\">([^<]+)");
        m = patt.matcher(page);
        if (m.find()) {
            String data = m.group(1);
            if (data.contains("N/A"))
                return;
            double val = 0;
            try {
                val = nf.parse(data.substring(0, data.length() - 1)).doubleValue();
            } catch (Exception e) {
                return;
            }
            if (data.endsWith("M"))
                val *= 1000000;
            if (data.endsWith("B"))
                val *= 1000000000;
            s.setOperatingCashFlow(val);
        } else {
            return;
        }
        patt = Pattern.compile("Shares\\s+Outstanding<font size=\"-1\"><sup>5</sup></font>:</td><td class=\"yfnc_tabledata1\">([^<]+)");
        m = patt.matcher(page);
        if (m.find()) {
            String data = m.group(1);
            if (data.contains("N/A"))
                return;
            double val = 0;
            try {
                val = nf.parse(data.substring(0, data.length() - 1)).doubleValue();
            } catch (Exception e) {
                return;
            }
            if (data.endsWith("M"))
                val *= 1000000;
            if (data.endsWith("B"))
                val *= 1000000000;
            s.setSharesOutstanding(val);
        } else {
            return;
        }
        patt = Pattern.compile("Held by Institutions<font size=\"-1\"><sup>1</sup></font>:</td><td class=\"yfnc_tabledata1\">([^<]+)");
        m = patt.matcher(page);
        if (m.find()) {
            String data = m.group(1);
            if (data.contains("N/A"))
                return;
            try {
                s.setPercentHeldByInstitutions(nf.parse(data.substring(0, data.length() - 1)).doubleValue());
            } catch (Exception e) {
                return;
            }
        } else {
            return;
        }
        if (s.isInterestingWithoutPrice()) {
            System.out.println("Interesting: " + s.getTicker());
            Connection conn = null;
            try {
                ResultSet rst = null;
                String q = "INSERT INTO interesting(dateObserved,ticker) VALUES(now(),'" + s.getTicker() + "');";
                final String cURL = "jdbc:mysql://192.168.5.12:3306/screener";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(cURL, "tmwsiy", "password");
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
    } catch (IOException ex) {
        System.err.println("I/O error: " + ex.getMessage());
    }
    RequestHandle handle = (RequestHandle) context.removeAttribute("request-handle");
    if (handle != null) {
        handle.completed();
    }
}}

