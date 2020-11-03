public class Dummy{
public int updateRoom(Room room) {
    Room r = room;
    int rc = -1;
    String query = "UPDATE Room SET " + "roomType='?' " + "WHERE number='?'";
    System.out.println("Update query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,r.getRoomType().getCategory());
        stmt.setObject(2,r.getNumber());
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (Exception e) {
        System.out.println("Update exception in Room: " + e);
    }
    return rc;
}}

