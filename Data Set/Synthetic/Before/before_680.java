public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, HIRE_DATE FROM EMPLOYEES WHERE HIRE_DATE <=" + val1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}