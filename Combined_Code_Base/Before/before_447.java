public class Dummy{
public int insertRoom(Room room) throws Exception {
    String query = "INSERT INTO Room(number, roomType)" + " VALUES('" + room.getNumber() + "','" + room.getRoomType().getCategory() + "')";
    int rc = -1;
    System.out.println("insert: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Room is not inserted");
        throw new Exception("Room is not inserted correctly!");
    }
    return rc;
}}

