public class Dummy{
public int insertRoomBooking(RoomBooking rb) throws Exception {
    String query = "INSERT INTO RoomBooking(arrivalDate, departureDate, stts, numberOfChildren)" +" VALUES('?','?','?','?')";
    int rc = -1;
    System.out.println("insert: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,rb.getArrivalDate());
        stmt.setObject(2,rb.getDepartureDate() );
        stmt.setObject(3,rb.getStatus());
        stmt.setObject(4,rb.getNumberOfChildren());
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("RoomBooking is not inserted");
        throw new Exception("RoomBooking is not inserted correctly!");
    }
    return rc;
}}

