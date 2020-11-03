public class Dummy{
public int deleteRoom(int number) {
    int rc = -1;
    String query = "DELETE FROM Room WHERE number=" + number;
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (Exception ex) {
        System.out.println("Delete exception in room db: " + ex);
    }
    return (rc);
}}

