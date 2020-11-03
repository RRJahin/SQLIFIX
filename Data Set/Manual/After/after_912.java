public class Dummy{
@Override
public int insertActivityBooking(ActivityBooking activityBooking) throws Exception {
    ActivityBooking acticityBookingObj = activityBooking;
    int nextActivityBookingId = GetMax.getMaxId("SELECT MAX(id) from ActivityBooking");
    nextActivityBookingId = nextActivityBookingId + 1;
    System.out.println("Next activity booking id = " + nextActivityBookingId);
    int result = -1;
    String query = "INSERT INTO ActivityBooking(id, guestId, date, status) VALUES ('?','?','?','?')";
    System.out.println("Insertion query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setObject(1,nextActivityBookingId );
        stmt.setObject(2,acticityBookingObj.getGuest().getId() );
        stmt.setObject(3,acticityBookingObj.getDate());
        stmt.setObject(4,acticityBookingObj.getStatus());
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Insertion exception: " + e);
    }
    return (result);
}}

