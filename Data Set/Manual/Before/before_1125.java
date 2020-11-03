public class Dummy{
public int deleteRoomType(String category) {
    int rc = -1;
    String query = "DELETE FROM RoomType WHERE category='" + category + "'";
    System.out.println("delete: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Delete exception in RoomType db.");
    }
    return rc;
}}

