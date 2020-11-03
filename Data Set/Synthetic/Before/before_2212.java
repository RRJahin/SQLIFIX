public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, MANAGER_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE MANAGER_ID =" + val2+" AND DEPARTMENT_ID =" + rand8;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}