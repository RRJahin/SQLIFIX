public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, JOB_ID FROM EMPLOYEES INTERSECT ( SELECT EMPLOYEE_ID, JOB_ID FROM JOB_HISTORY where JOB_ID>="+id+")";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}