public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, JOB_ID FROM EMPLOYEES WHERE JOB_ID >=" + val1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}