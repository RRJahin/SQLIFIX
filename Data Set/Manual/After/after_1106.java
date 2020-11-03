public class Dummy{
@Override
public int deleteLocation(int zipcode, String country) {
    int rc = -1;
    String query = "DELETE FROM Location WHERE zipCode= '?' AND country= '?'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement();
        stmt.setQueryTimeout(5);
        stmt.setObject(1,zipcode);
        stmt.setObject(2,country);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (Exception ex) {
        System.out.println("Delete exception: " + ex);
    }
    return (rc);
}}

