public class Dummy{
    @Override
    public int updateActivityBookingStatus(ActivityBooking activityBooking) {
        ActivityBooking activityBookingObj = activityBooking;
        String query = "UPDATE ActivityBooking SET " + " status= '?' " + "WHERE id= '?'";
        int result = -1;
        System.out.println("Update query: " + query);
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setQueryTimeout(5);
            stmt.setObject(1,activityBookingObj.getStatus());
            stmt.setObject(2,activityBookingObj.getId());
    
            result = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Update exception: " + e);
        }
        return (result);
    }}
    