public class Dummy{
@Override
public int insertEmployee(Employee employeeObj) throws Exception {
    int result = -1;
    String query = "INSERT INTO Employee(personId, salary) VALUES ('" + employeeObj.getId() + "','" + employeeObj.getSalary() + "')";
    System.out.println("Insertion query: " + query);
    try {
        Statement stmt = con.createStatement();
        stmt.setQueryTimeout(5);
        result = stmt.executeUpdate(query);
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Insertion exception: " + e);
    }
    return (result);
}}

