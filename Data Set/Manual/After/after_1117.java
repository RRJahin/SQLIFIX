public class Dummy{
public int deleteRoom(int number) {
    int rc = -1;
    String query = "DELETE FROM Room WHERE number=?";
    System.out.println(query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,number);
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (Exception ex) {
        System.out.println("Delete exception in room db: " + ex);
    }
    return (rc);
}}

