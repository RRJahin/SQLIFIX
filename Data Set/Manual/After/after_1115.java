public class Dummy{
@Override
public int getPersonInstances(int id, String name, int zipcode, String country, String address) {
    int instances = 0;
    ResultSet results;
    String query = "SELECT COUNT(*) AS personInstances FROM Person " + " WHERE id<> '?' AND name= '?' AND zipcode= '?' AND country= '?' AND address= '?'";
    System.out.println(query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,id);
        stmt.setObject(2,name);
        stmt.setObject(3,zipcode);
        stmt.setObject(4,country);
        stmt.setObject(5,address);
        results = stmt.executeQuery();
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

