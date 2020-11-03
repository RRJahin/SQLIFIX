public class Dummy{
@Override
public int getFacilityInstances(int id, String name) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS facilityInstances FROM Facility " + " WHERE id<> '" + id + "' AND name= '" + name + "'";
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        results = stmt.executeQuery(query);
        while (results.next()) {
            instances = results.getInt("facilityInstances");
            System.out.println("Facility instances: " + instances);
        }
        stmt.close();
    } catch (Exception e) {
        System.out.println("Exception in returning the facility instance count: " + e);
    }
    return instances;
}}

