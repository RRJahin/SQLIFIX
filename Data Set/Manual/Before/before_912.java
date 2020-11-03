public class Dummy{
@Override
public int insertActivityBooking(ActivityBooking activityBooking) throws Exception {
    ActivityBooking acticityBookingObj = activityBooking;
    int nextActivityBookingId = GetMax.getMaxId("SELECT MAX(id) from ActivityBooking");
    nextActivityBookingId = nextActivityBookingId + 1;
    System.out.println("Next activity booking id = " + nextActivityBookingId);
    int result = -1;
    String query = "INSERT INTO ActivityBooking(id, guestId, date, status) VALUES ('" + nextActivityBookingId + "','" + acticityBookingObj.getGuest().getId() + "','" + acticityBookingObj.getDate() + "','" + acticityBookingObj.getStatus() + "')";
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

