public class Dummy{
@Override
public int deleteActivityTypeByName(String name) {
    int result = -1;
    String query = "DELETE FROM ActivityType WHERE name= '" + name + "'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,name);
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

