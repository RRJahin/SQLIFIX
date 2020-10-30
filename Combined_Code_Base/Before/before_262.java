public class Dummy{
@Override
public int updateActivityLine(ActivityLine activityLine) {
    int result = -1;
    String query = "UPDATE ActivityLine SET " + " status= '" + activityLine.getStatus() + "' " + "WHERE activityId= '" + activityLine.getActivity().getID() + "' " + "AND bookingId= '" + activityLine.getActivityBooking().getId() + "' " + "AND facilityId= '" + activityLine.getFacility().getId() + "' " + "AND date= '" + activityLine.getDate() + "' " + "AND startHour= '" + activityLine.getStartHour() + "' ";
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

