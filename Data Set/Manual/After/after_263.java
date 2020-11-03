public class Dummy{
@Override
public int deleteActivityLine(int activityId, int bookingId, String date, String startHour) {
    int result = -1;
    String query = "DELETE FROM ActivityLine WHERE activityId= '?' AND bookingId= '?' AND date= '?' AND startHour= '?'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,activityId );
        stmt.setObject(2,bookingId);
        stmt.setObject(3,date);
        stmt.setObject(4,startHour);

        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

