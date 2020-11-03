public class Dummy{
@Override
public int getTravelAgencyInstances(int cvr, String name, int zipcode, String country, String address) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS travelAgencyInstances FROM TravelAgency " + " WHERE cvr<> '" + cvr + "' AND name= '" + name + "' AND zipcode= '" + zipcode + "' AND country= '" + country + "' AND address= '" + address + "'";
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        results = stmt.executeQuery(query);
        while (results.next()) {
            instances = results.getInt("travelAgencyInstances");
            System.out.println("Travel agency instances: " + instances);
        }
        stmt.close();
    } catch (Exception e) {
        System.out.println("Exception in returning the travel agency instance count: " + e);
    }
    return instances;
}}

