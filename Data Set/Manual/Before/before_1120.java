public class Dummy{
public int updateRoomBooking(RoomBooking rb) {
    RoomBooking roomBooking = rb;
    int rc = -1;
    String query = "UPDATE RoomBooking SET " + "arrivalDate='" + roomBooking.getArrivalDate() + "', " + "departureDate='" + roomBooking.getDepartureDate() + "', " + "stts='" + roomBooking.getStatus() + "', " + "numberOfChildren='" + roomBooking.getNumberOfChildren() + "' " + "WHERE id='" + roomBooking.getId() + "'";
    System.out.println("Update query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (Exception e) {
        System.out.println("Update exception in RoomBooking: " + e);
    }
    return rc;
}}

