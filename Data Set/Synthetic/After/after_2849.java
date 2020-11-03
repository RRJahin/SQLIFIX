public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID,JOB_ID=(SELECT EMPLOYEE_ID, JOB_ID FROM EMPLOYEES MINUS ( SELECT EMPLOYEE_ID, JOB_ID FROM JOB_HISTORY where JOB_ID<?))");
		stmt.setObject(1 , ID);
		ResultSet rs = stmt.executeQuery();
	}
}