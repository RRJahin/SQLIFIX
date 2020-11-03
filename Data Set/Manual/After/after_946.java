import java.sql.PreparedStatement;

public class Dummy{
@Override
public int getActivityLineInstances1(int activityId, int bookingId, String date, String startHour, int facilityId, String status) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityLineInstances1 FROM ActivityLine " + "WHERE activityId= '?' " + "AND bookingId= '?' " + "AND date= '?' " + "AND startHour= '?' " + "AND facilityId= '?' " + "AND status= '?'";
    System.out.println(query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,activityId);
        stmt.setObject(2,bookingId);
        stmt.setObject(3, date);
        stmt.setObject(4,startHour);
        stmt.setObject(5,facilityId);
        stmt.setObject(6,status);
        results = stmt.executeQuery();
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

