public class Dummy{
public int updateRoomType(RoomType roomType) {
    RoomType rt = roomType;
    int rc = -1;
    String query = "UPDATE RoomType SET " + "typeDescription='?', " + "price='?' WHERE category='?'";
    System.out.println("Update query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,rt.getDescription());
        stmt.setObject(2,rt.getPrice());
        stmt.setObject(3,rt.getCategory());
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (Exception e) {
        System.out.println("Update exception in Room: " + e);
    }
    return rc;
}}

