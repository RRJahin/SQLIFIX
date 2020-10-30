public class Dummy{
@Override
public int insertActivityType(ActivityType activityTypeObj) throws Exception {
    int nextActivityTypeId = GetMax.getMaxId("SELECT MAX(id) from ActivityType");
    nextActivityTypeId = nextActivityTypeId + 1;
    System.out.println("Next activity type id = " + nextActivityTypeId);
    int result = -1;
    String query = "INSERT INTO ActivityType(id, name, maxParticipants) VALUES ('?','?','?')";
    System.out.println("Insertion query: " + query);
    try {
    PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,nextActivityTypeId);
        stmt.setObject(2,activityTypeObj.getName() );
        stmt.setObject(3,activityTypeObj.getMaxParticipants());
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Insertion exception: " + e);
    }
    return (result);
}}

