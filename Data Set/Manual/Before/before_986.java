public class Dummy{
@Override
public int insertActivityType(ActivityType activityTypeObj) throws Exception {
    int nextActivityTypeId = GetMax.getMaxId("SELECT MAX(id) from ActivityType");
    nextActivityTypeId = nextActivityTypeId + 1;
    System.out.println("Next activity type id = " + nextActivityTypeId);
    int result = -1;
    String query = "INSERT INTO ActivityType(id, name, maxParticipants) VALUES ('" + nextActivityTypeId + "','" + activityTypeObj.getName() + "','" + activityTypeObj.getMaxParticipants() + "')";
    System.out.println("Insertion query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Insertion exception: " + e);
    }
    return (result);
}}

