public class Dummy{
public int insertRoomType(RoomType rt) throws Exception {
    String query = "INSERT INTO RoomType(category, typeDescription, price)" + " VALUES('" + rt.getCategory() + "','" + rt.getDescription() + "','" + rt.getPrice() + "')";
    int rc = -1;
    System.out.println("insert: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("RoomType is not inserted");
        throw new Exception("RoomType is not inserted correctly!");
    }
    return rc;
}}

