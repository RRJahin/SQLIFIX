public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID,JOB_ID=(SELECT EMPLOYEE_ID, JOB_ID FROM EMPLOYEES UNION ALL ( SELECT EMPLOYEE_ID, JOB_ID FROM JOB_HISTORY where JOB_ID="+ID+"))");
	}
}