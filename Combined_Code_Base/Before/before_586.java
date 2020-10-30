class Dummy{
public static void insertAlert(HttpServletResponse response, Connection dbCon, String sensorType, String comparator, int compValue, int node) {
    String query = "INSERT INTO alerts (sensor_type, comparator, comparison_value, node_id) VALUES ("+sensorType+", "+comparator+", "+compValue+", "+node+");";
    try {
        Statement insertAlert = dbCon.createStatement();
        insertAlert.executeUpdate(query);
        dbCon.close();
    } catch (SQLException ex) {
        PrintWriter out;
        try {
            out = new PrintWriter(response.getOutputStream());
            response.setContentType("text/html");
            out.print("Couldn't get data:" + ex);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}}

