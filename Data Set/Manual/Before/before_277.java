public class Dummy{
@Override
public int getActivityLineInstances1(int activityId, int bookingId, String date, String startHour, int facilityId, String status) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityLineInstances1 FROM ActivityLine " + "WHERE activityId= '" + activityId + "' " + "AND bookingId= '" + bookingId + "' " + "AND date= '" + date + "' " + "AND startHour= '" + startHour + "' " + "AND facilityId= '" + facilityId + "' " + "AND status= '" + status + "'";
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        results = stmt.executeQuery(query);
        while (results.next()) {
            instances = results.getInt("activityLineInstances1");
            System.out.println("Activity line instances1= " + instances);
        }
        stmt.close();
    } catch (Exception e) {
        System.out.println("Exception in returning the activity line instance count: " + e);
    }
    return instances;
}}

