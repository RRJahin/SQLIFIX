public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, PHONE_NUMBER, HIRE_DATE FROM EMPLOYEES WHERE PHONE_NUMBER =" + val1+" AND HIRE_DATE =" + rand3;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}