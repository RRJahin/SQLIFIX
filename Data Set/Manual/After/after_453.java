public class Dummy{
public int insertRoomLine(RoomLine roomLine) throws Exception {
    String query = "INSERT INTO RoomLine(guestId, roomNo, booking) VALUES('?', '?', '?')";
    int rc = -1;
    System.out.println("insert: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1, roomLine.getGuest().getId() );
        stmt.setObject(2,roomLine.getRoom().getNumber());
        stmt.setObject(3,roomLine.getBooking().getId());
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("RoomLine is not inserted");
        throw new Exception("RoomLine is not inserted correct");
    }
    return rc;
}}

