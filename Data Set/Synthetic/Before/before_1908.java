public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, HIRE_DATE, JOB_ID FROM EMPLOYEES WHERE HIRE_DATE <=" + val1+" AND JOB_ID <" + rand4);
	}
}