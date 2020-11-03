public class Dummy{
@Override
public int getActivityBookingInstances(String date, int guestId) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityBokingInstances FROM ActivityBooking " + " WHERE date='?' AND guestId='?' AND status<>'Canceled'";
    System.out.println(query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,data);
        stmt.setObject(2,guestId);
        results = stmt.executeQuery();
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

