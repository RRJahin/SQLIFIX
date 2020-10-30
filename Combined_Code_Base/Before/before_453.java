public class Dummy{
public int insertRoomLine(RoomLine roomLine) throws Exception {
    String query = "INSERT INTO RoomLine(guestId, roomNo, booking) VALUES('" + roomLine.getGuest().getId() + "', '" + roomLine.getRoom().getNumber() + "', '" + roomLine.getBooking().getId() + "')";
    int rc = -1;
    System.out.println("insert: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("RoomLine is not inserted");
        throw new Exception("RoomLine is not inserted correct");
    }
    return rc;
}}

