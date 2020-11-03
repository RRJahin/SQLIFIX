public class Dummy{
public int updateRoomType(RoomType roomType) {
    RoomType rt = roomType;
    int rc = -1;
    String query = "UPDATE RoomType SET " + "typeDescription='" + rt.getDescription() + "', " + "price=" + rt.getPrice() + " WHERE category='" + rt.getCategory() + "'";
    System.out.println("Update query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (Exception e) {
        System.out.println("Update exception in Room: " + e);
    }
    return rc;
}}

