public class Dummy{
@Override
public int insertEmployee(Employee employeeObj) throws Exception {
    int result = -1;
    String query = "INSERT INTO Employee(personId, salary) VALUES ('?','?')";
    System.out.println("Insertion query: " + query);
    try {
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setQueryTimeout(5);
        stmt.setObject(1,employeeObj.getId());
        stmt.setObject(2,employeeObj.getSalary());
        result = stmt.executeUpdate();
        stmt.close();
    } catch (SQLException e) {
        System.out.println("Insertion exception: " + e);
    }
    return (result);
}}

