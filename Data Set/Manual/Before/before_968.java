public class Dummy{
@Override
public int getNumberOfActivityLinesInActivityBooking(int bookingId, String date) {
    int numbers = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS activityLineNumbers FROM ActivityLine " + " WHERE bookingId='" + bookingId + "' AND date= '" + date + "' AND status<>'Canceled' ";
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        results = stmt.executeQuery(query);
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

