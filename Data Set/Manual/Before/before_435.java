public class Dummy{
@Override
public int insertLocation(Location loc) throws Exception {
    String query = "INSERT INTO Location(zipcode, country, city) VALUES('" + loc.getZipCode() + "','" + loc.getCountry() + "','" + loc.getCity() + "')";
    int rc = -1;
    System.out.println("Insertion query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        rc = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Insertion exception: " + ex);
    }
    return rc;
}}

