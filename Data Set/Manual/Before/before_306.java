public class Dummy{
@Override
public int getActivityLineInstances4(int bookingId, String date, String startHour) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityLineInstances3 FROM ActivityLine " + " WHERE bookingId= '" + bookingId + "' " + "AND date= '" + date + "' " + "AND startHour= '" + startHour + "' " + "AND startHour= '" + startHour + "' " + "AND status<>'Canceled' ";
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

