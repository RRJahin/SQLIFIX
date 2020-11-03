public class Dummy{
public int deleteRoomLine(int guestId, int roomNo, int booking) {
    int rc = -1;
    String query = "DELETE FROM RoomLine WHERE guestId=" + guestId + " AND roomNo=" + roomNo + " AND booking=" + booking;
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (Exception ex) {
        System.out.println("Delete exception in room line db: " + ex);
    }
    return (rc);
}}

