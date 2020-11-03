public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, JOB_ID FROM JOB_HISTORY WHERE JOB_ID <>" + var2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}