public class Dummy{
@Override
public int updateLocation(Location loc) {
    int rc = -1;
    String query = "UPDATE Location SET " + "zipCode= '?', " + "city= '?' " + "WHERE country= '?'";
    System.out.println("Update query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,loc.getZipCode());
        stmt.setObject(2,loc.getCity());
        stmt.setObject(3,loc.getCountry());
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (Exception e) {
        System.out.println("Update exception: " + e);
    }
    return rc;
}}

