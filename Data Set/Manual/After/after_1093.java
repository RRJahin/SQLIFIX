public class Dummy{
@Override
public int deleteEmployeeById(int id) {
    int result = -1;
    String query = "DELETE FROM Employee WHERE personId= '?'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement();
        stmt.setQueryTimeout(5);
        stmt.setObject(1,id);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

