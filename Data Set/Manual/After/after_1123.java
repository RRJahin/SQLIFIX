public class Dummy{
public int deleteRoomLine(int guestId, int roomNo, int booking) {
    int rc = -1;
    String query = "DELETE FROM RoomLine WHERE guestId=? AND roomNo=? AND booking=?" ;
    System.out.println(query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,guestId );
        stmt.setObject(2,roomNo);
        stmt.setObject(3,booking);
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (Exception ex) {
        System.out.println("Delete exception in room line db: " + ex);
    }
    return (rc);
}}

