public class Dummy{
@Override
public int updateEmployee(Employee employeeObj) {
    int result = -1;
    Employee employeeNewObj = employeeObj;
    String query = "UPDATE Employee SET " + "salary= '" + employeeNewObj.getSalary() + "' " + "WHERE personId= '" + employeeNewObj.getId() + "'";
    System.out.println("Update query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Update exception: " + e);
    }
    return (result);
}}

