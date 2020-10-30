public class Dummy{
@Override
public int getPersonInstances(int id, String name, int zipcode, String country, String address) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS personInstances FROM Person " + " WHERE id<> '" + id + "' AND name= '" + name + "' AND zipcode= '" + zipcode + "' AND country= '" + country + "' AND address= '" + address + "'";
    System.out.println(query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        results = stmt.executeQuery(query);
        while (results.next()) {
            instances = results.getInt("personInstances");
            System.out.println("Person instances: " + instances);
        }
        stmt.close();
    } catch (Exception e) {
        System.out.println("Exception in returning the person instance count: " + e);
    }
    return instances;
}}

