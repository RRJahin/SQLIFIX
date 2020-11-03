public class Dummy{
@Override
public int updateActivityType(ActivityType activityTypeObj) {
    int result = -1;
    ActivityType activityTypeNewObj = activityTypeObj;
    String query = "UPDATE ActivityType SET " + "name= '" + activityTypeNewObj.getName() + "', " + "maxParticipants= '" + activityTypeNewObj.getMaxParticipants() + "' " + "WHERE id= '" + activityTypeNewObj.getID() + "'";
    System.out.println("Update query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Update exception: " + e);
    }
    return (result);
}}

