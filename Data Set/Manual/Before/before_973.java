public class Dummy{
@Override
public int getActivityLineInstances3(int activityId, String date, String startHour, int facilityId) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityLineInstances3 FROM ActivityLine " + " WHERE activityId= '" + activityId + "' " + "AND date= '" + date + "' " + "AND startHour= '" + startHour + "' " + "AND facilityId= '" + facilityId + "' " + "AND status<>'Canceled' ";
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        results = stmt.executeQuery(query);
        while (results.next()) {
            instances = results.getInt("activityLineInstances3");
            System.out.println("Activity line instances3= " + instances);
        }
        stmt.close();
    } catch (Exception e) {
        System.out.println("Exception in returning the activity line instance count: " + e);
    }
    return instances;
}}

