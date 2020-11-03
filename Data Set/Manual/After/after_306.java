public class Dummy{
@Override
public int getActivityLineInstances4(int bookingId, String date, String startHour) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityLineInstances3 FROM ActivityLine " + " WHERE bookingId= '?' " + "AND date= '?' " + "AND startHour= '?' " + "AND startHour= '?' " + "AND status<>'Canceled' ";
    System.out.println(query);
    try {
    PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,bookingId );
        stmt.setObject(2,date);
        stmt.setObject(3,startHour);
        stmt.setObject(4,startHour);
        results = stmt.executeQuery();
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

