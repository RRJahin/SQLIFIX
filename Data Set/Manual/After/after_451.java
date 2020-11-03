import java.sql.PreparedStatement;

public class Dummy{
public int updateRoomBooking(RoomBooking rb) {
    RoomBooking roomBooking = rb;
    int rc = -1;
    String query = "UPDATE RoomBooking SET " + "arrivalDate='?', " + "departureDate='?', " + "stts='?', " +"numberOfChildren='?' " + "WHERE id='?'";
    System.out.println("Update query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,roomBooking.getArrivalDate());
        stmt.setObject(2,roomBooking.getDepartureDate()  );
        stmt.setObject(3,roomBooking.getStatus());
        stmt.setObject(4,roomBooking.getNumberOfChildren());
        stmt.setObject(5,roomBooking.getId());
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (Exception e) {
        System.out.println("Update exception in RoomBooking: " + e);
    }
    return rc;
}}

