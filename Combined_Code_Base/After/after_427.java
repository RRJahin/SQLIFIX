public class Dummy{
@Override
public int deleteGuest(int guestId) {
    int rc = -1;
    String query = "DELETE FROM Guest WHERE personId= '?'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement();
        stmt.setQueryTimeout(5);
        stmt.setObject(1,guestId);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Delete exception: " + ex);
    }
    return (rc);
}}

