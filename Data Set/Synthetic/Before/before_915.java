public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE DEPARTMENT_ID <>" + var1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}