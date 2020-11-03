public class Dummy{
@Override
public int updateEmployee(Employee employeeObj) {
    int result = -1;
    Employee employeeNewObj = employeeObj;
    String query = "UPDATE Employee SET " + "salary= '?' " + "WHERE personId= '?'";
    System.out.println("Update query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,employeeNewObj.getSalary() );
        stmt.setObject(2,employeeNewObj.getId() );
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Update exception: " + e);
    }
    return (result);
}}

