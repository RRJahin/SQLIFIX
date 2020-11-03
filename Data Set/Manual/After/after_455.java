public class Dummy{
public int insertRoomType(RoomType rt) throws Exception {
    String query = "INSERT INTO RoomType(category, typeDescription, price)" + " VALUES('?','?','?')";
    int rc = -1;
    System.out.println("insert: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,rt.getCategory());
        stmt.setObject(2,rt.getDescription());
        stmt.setObject(3,rt.getPrice());
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("RoomType is not inserted");
        throw new Exception("RoomType is not inserted correctly!");
    }
    return rc;
}}

