public class Dummy{
public int deleteRoomBooking(int roomBookingId) {
    int rc = -1;
    String query = "DELETE FROM RoomBooking WHERE id = '" + roomBookingId + "'";
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (Exception ex) {
        System.out.println("Delete exception in RoomBooking: " + ex);
    }
    return (rc);
}}

