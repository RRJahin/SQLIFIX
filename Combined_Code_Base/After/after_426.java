public class Dummy{
@Override
public int getFacilityInstances(int id, String name) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS facilityInstances FROM Facility " + " WHERE id<> '?' AND name= '?'";
    System.out.println(query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,id);
        stmt.setObject(2,name);
        results = stmt.executeQuery();
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

