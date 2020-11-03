public class Dummy{
@Override
public int getActivityTypeInstances(int id, String name) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityTypeInstances FROM ActivityType " + " WHERE id<> '" + id + "' AND name= '" + name + "'";
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        results = stmt.executeQuery(query);
        while (results.next()) {
            instances = results.getInt("activityTypeInstances");
            System.out.println("Activity type instances: " + instances);
        }
        stmt.close();
    } catch (Exception e) {
        System.out.println("Exception in returning the activity type instance count: " + e);
    }
    return instances;
}}

