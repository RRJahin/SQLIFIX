public class Dummy{
@Override
public int deleteLocation(int zipcode, String country) {
    int rc = -1;
    String query = "DELETE FROM Location WHERE zipCode= '" + zipcode + "' AND country= '" + country + "'";
    System.out.println("Delete query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (Exception ex) {
        System.out.println("Delete exception: " + ex);
    }
    return (rc);
}}

