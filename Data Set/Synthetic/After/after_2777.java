public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, JOB_ID FROM EMPLOYEES MINUS ( SELECT EMPLOYEE_ID, JOB_ID FROM JOB_HISTORY where JOB_ID>=?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id);
		stmt.executeQuery();
	}
}