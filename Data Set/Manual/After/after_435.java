public class Dummy{
@Override
public int insertLocation(Location loc) throws Exception {
    String query = "INSERT INTO Location(zipcode, country, city) VALUES('?','?','?')";
    int rc = -1;
    System.out.println("Insertion query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,loc.getZipCode());
        stmt.setObject(2,loc.getCountry());
        stmt.setObject(3,loc.getCity());
        rc = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException ex) {
        System.out.println("Insertion exception: " + ex);
    }
    return rc;
}}

