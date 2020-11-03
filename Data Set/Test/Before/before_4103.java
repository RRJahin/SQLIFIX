class Dummy{
public static int initializeGatherRun(int marketid) {
    Connection conn = null;
    final String cURL = "jdbc:mysql://192.168.5.12:3306/screener";
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(cURL, "screen", "password");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "INSERT INTO gather_runs (marketid, " + "time_started," + " time_completed," + " is_completed," + " last_completed_id," + " isStarted)" + " VALUES(" + marketid + ",now(),null,0,0,1);";
        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = null;
        int autoIncKeyFromApi = -1;
        rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            autoIncKeyFromApi = rs.getInt(1);
        } else {
            throw new Exception("Error inserting new gather Run");
        }
        rs.close();
        rs = null;
        return autoIncKeyFromApi;
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
    return -1;
}}

