public class Dummy{
@Override
public int getActivityLineInstances2(String date, String startHour, int instructorId) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityLineInstances2 FROM ActivityLine " + " WHERE date='?' AND startHour= '?' AND instructorId= '?'" + " AND status<>'Canceled' ";
    System.out.println(query);
    try {
    PreparedStatement stmt = con.prepareStatement(query);
    stmt.setObject(1,date);
    stmt.setObject(2,startHour);
    stmt.setObject(3,instructorId);
        stmt.setQueryTimeout(5);
        results = stmt.executeQuery();
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

