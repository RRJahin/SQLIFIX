public class Dummy{
@Override
public int deleteActivityLine(int activityId, int bookingId, String date, String startHour) {
    int result = -1;
    String query = "DELETE FROM ActivityLine WHERE activityId= '" + activityId + "' AND bookingId= '" + bookingId + "' AND date= '" + date + "' AND startHour= '" + startHour + "'";
    System.out.println("Delete query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

