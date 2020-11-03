
public class Dummy{
    @Override
    public int updateActivityBookingStatus(ActivityBooking activityBooking) {
        ActivityBooking activityBookingObj = activityBooking;
        String query = "UPDATE ActivityBooking SET " + " status= '" + activityBookingObj.getStatus() + "' " + "WHERE id= '" + activityBookingObj.getId() + "'";
        int result = -1;
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
    
    