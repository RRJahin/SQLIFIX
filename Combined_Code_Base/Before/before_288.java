public class Dummy{
@Override
public int getActivityLineInstances2(String date, String startHour, int instructorId) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityLineInstances2 FROM ActivityLine " + " WHERE date='" + date + "' AND startHour= '" + startHour + "' AND instructorId= '" + instructorId + "'" + " AND status<>'Canceled' ";
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        results = stmt.executeQuery(query);
        while (results.next()) {
            instances = results.getInt("activityLineInstances2");
            System.out.println("Activity line instances2= " + instances);
        }
        stmt.close();
    } catch (Exception e) {
        System.out.println("Exception in returning the activity line instance count: " + e);
    }
    return instances;
}}

