public class Dummy{
public int updateRoom(Room room) {
    Room r = room;
    int rc = -1;
    String query = "UPDATE Room SET " + "roomType='" + r.getRoomType().getCategory() + "' " + "WHERE number='" + r.getNumber() + "'";
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

