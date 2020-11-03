public class Dummy{
@Override
public int updateActivityLine(ActivityLine activityLine) {
    int result = -1;
    String query = "UPDATE ActivityLine SET " + " status= '?' " + "WHERE activityId= '?' " + "AND bookingId= '?' " + "AND facilityId= '?' " + "AND date= '?' " + "AND startHour= '?' ";
    System.out.println("Update query: " + query);
    try {
        PreparedStatement stmt = con.createStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,activityLine.getStatus());
        stmt.setObject(2,activityLine.getActivity().getID());
        stmt.setObject(3,activityLine.getActivityBooking().getId());
        stmt.setObject(4,activityLine.getFacility().getId());
        stmt.setObject(5,activityLine.getDate());
        stmt.setObject(6,activityLine.getStartHour());
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Update exception: " + e);
    }
    return (result);
}}

