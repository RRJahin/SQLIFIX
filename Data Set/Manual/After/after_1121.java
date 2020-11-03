public class Dummy{
public int deleteRoomBooking(int roomBookingId) {
    int rc = -1;
    String query = "DELETE FROM RoomBooking WHERE id = '?'";
    System.out.println(query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,roomBookingId);
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (Exception ex) {
        System.out.println("Delete exception in RoomBooking: " + ex);
    }
    return (rc);
}}

