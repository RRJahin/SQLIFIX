public class Dummy{
public int insertRoomBooking(RoomBooking rb) throws Exception {
    String query = "INSERT INTO RoomBooking(arrivalDate, departureDate, stts, numberOfChildren)" + " VALUES('" + rb.getArrivalDate() + "','" + rb.getDepartureDate() + "','" + rb.getStatus() + "','" + rb.getNumberOfChildren() + "')";
    int rc = -1;
    System.out.println("insert: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("RoomBooking is not inserted");
        throw new Exception("RoomBooking is not inserted correctly!");
    }
    return rc;
}}

