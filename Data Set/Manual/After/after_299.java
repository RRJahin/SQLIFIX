public class Dummy{
@Override
public int getNumberOfActivityLinesInActivityBooking(int bookingId, String date) {
    int numbers = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityLineNumbers FROM ActivityLine " + " WHERE bookingId='?' AND date= '?' AND status<>'Canceled' ";
    System.out.println(query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,bookingId );
        stmt.setObject(2,data);
        results = stmt.executeQuery();
        while (results.next()) {
            numbers = results.getInt("activityLineNumbers");
            System.out.println("Number of activity lines per booking= " + numbers);
        }
        stmt.close();
    } catch (Exception e) {
        System.out.println("Exception in returning the activity line number count: " + e);
    }
    return numbers;
}}

