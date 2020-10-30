public class Dummy{
@Override
public int deleteActivityBookingForDate(int guestId, String date) {
    int result = -1;
    String query = "DELETE FROM ActivityBooking WHERE guestId= '?' AND date= '?'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,guestId);
        stmt.setObject(2,data);
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

