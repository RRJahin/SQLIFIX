public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, MANAGER_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE MANAGER_ID <=" + var2+" AND DEPARTMENT_ID <" + rand8);
	}
}