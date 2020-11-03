public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, JOB_ID FROM EMPLOYEES UNION ALL ( SELECT EMPLOYEE_ID, JOB_ID FROM JOB_HISTORY where JOB_ID>=?)");
		stmt.setObject(1 , id);
		ResultSet rs = stmt.executeQuery();
	}
}