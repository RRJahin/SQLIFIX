public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, HIRE_DATE FROM EMPLOYEES WHERE HIRE_DATE =" + var2);
	}
}