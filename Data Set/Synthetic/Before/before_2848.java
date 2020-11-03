public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID,JOB_ID=(SELECT EMPLOYEE_ID, JOB_ID FROM EMPLOYEES MINUS ( SELECT EMPLOYEE_ID, JOB_ID FROM JOB_HISTORY where JOB_ID="+ID+"))";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}