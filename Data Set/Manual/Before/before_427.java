public class Dummy{
@Override
public int deleteGuest(int guestId) {
    int rc = -1;
    String query = "DELETE FROM Guest WHERE personId= '" + guestId + "'";
    System.out.println("Delete query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Delete exception: " + ex);
    }
    return (rc);
}}

