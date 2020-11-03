public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, JOB_ID FROM EMPLOYEES MINUS ( SELECT EMPLOYEE_ID, JOB_ID FROM JOB_HISTORY where JOB_ID>="+id+")");
	}
}