public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE DEPARTMENT_ID <>" + val1);
	}
}