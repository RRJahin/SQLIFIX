public class Dummy{
@Override
public int deleteInstructorById(int employeeId) {
    int result = -1;
    String query = "DELETE FROM Instructor WHERE employeeId= '" + employeeId + "'";
    System.out.println("Delete query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

