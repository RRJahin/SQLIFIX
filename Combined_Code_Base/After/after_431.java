public class Dummy{
@Override
public int deleteInstructorById(int employeeId) {
    int result = -1;
    String query = "DELETE FROM Instructor WHERE employeeId= '?'";
    System.out.println("Delete query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,employeeId);
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Delete exception: " + e);
    }
    return (result);
}}

