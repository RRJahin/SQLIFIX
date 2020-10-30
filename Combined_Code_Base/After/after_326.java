public class Dummy{
@Override
public int updateActivityType(ActivityType activityTypeObj) {
    int result = -1;
    ActivityType activityTypeNewObj = activityTypeObj;
    String query = "UPDATE ActivityType SET " + "name= '?', " + "maxParticipants= '?' " + "WHERE id= '?'";
    System.out.println("Update query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,activityTypeNewObj.getName());
        stmt.setObject(2,activityTypeNewObj.getMaxParticipants() );
        stmt.setObject(3,activityTypeNewObj.getID());
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Update exception: " + e);
    }
    return (result);
}}

