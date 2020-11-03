public class Dummy{
@Override
public int getActivityBookingInstances(String date, int guestId) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityBokingInstances FROM ActivityBooking " + " WHERE date='" + date + "' AND guestId='" + guestId + "' AND status<>'Canceled'";
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        results = stmt.executeQuery(query);
        while (results.next()) {
            instances = results.getInt("activityBokingInstances");
            System.out.println("Activity booking instances: " + instances);
        }
        stmt.close();
    } catch (Exception e) {
        System.out.println("Exception in returning the activity booking instance count: " + e);
    }
    return instances;
}}

