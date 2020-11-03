public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID,JOB_ID=(SELECT EMPLOYEE_ID, JOB_ID FROM EMPLOYEES UNION ALL ( SELECT EMPLOYEE_ID, JOB_ID FROM JOB_HISTORY where JOB_ID>=?))";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , ID);
		stmt.executeQuery();
	}
}