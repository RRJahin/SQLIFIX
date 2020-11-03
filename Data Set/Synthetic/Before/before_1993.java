public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES
SET DEPARTMENT_ID = 50
WHERE EMPLOYEE_ID >" +id1;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}