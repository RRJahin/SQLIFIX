public class Dummy{
public int insertRoom(Room room) throws Exception {
    String query = "INSERT INTO Room(number, roomType)" + " VALUES('?','?')";
    int rc = -1;
    System.out.println("insert: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,room.getNumber());
        stmt.setObject(2,room.getRoomType().getCategory());
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Room is not inserted");
        throw new Exception("Room is not inserted correctly!");
    }
    return rc;
}}

