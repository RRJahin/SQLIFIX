public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, START_DATE FROM JOB_HISTORY WHERE START_DATE =" + val2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}