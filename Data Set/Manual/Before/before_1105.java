public class Dummy{
@Override
public int updateLocation(Location loc) {
    int rc = -1;
    String query = "UPDATE Location SET " + "zipCode= '" + loc.getZipCode() + "', " + "city= '" + loc.getCity() + "' " + "WHERE country= '" + loc.getCountry() + "'";
    System.out.println("Update query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (Exception e) {
        System.out.println("Update exception: " + e);
    }
    return rc;
}}

