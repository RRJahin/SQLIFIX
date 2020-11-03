class Dummy{
public static ArrayList<Alert> getAlertsOfTypeForNode(HttpServletResponse response, Connection dbCon, String sensorType, int node) {
    String query = "SELECT sensor_type, comparator, comparison_value FROM alerts WHERE node_id = ? AND sensor_type = ?;";
    try {
        PreparedStatement selectAlerts = dbCon.prepareStatement(query);
        selectAlerts.setObject(1, node);
        selectAlerts.setObject(2, sensorType);
        ResultSet rAlerts = selectAlerts.executeQuery();
        ArrayList<Alert> alerts = new ArrayList<Alert>();
        while (rAlerts.next()) {
            Alert currentAlert = new Alert();
            currentAlert.setSensorType(rAlerts.getString("sensor_type"));
            currentAlert.setComparator(rAlerts.getString("comparator"));
            currentAlert.setComparisonValue(rAlerts.getInt("comparison_value"));
            alerts.add(currentAlert);
        }
        dbCon.close();
        return alerts;
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
        return null;
    }
}}

