public class Dummy{
public int deleteRoomType(String category) {
    int rc = -1;
    String query = "DELETE FROM RoomType WHERE category='?'";
    System.out.println("delete: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,catagory);
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Delete exception in RoomType db.");
    }
    return rc;
}}

