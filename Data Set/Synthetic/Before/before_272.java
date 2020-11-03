public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, START_DATE FROM JOB_HISTORY WHERE START_DATE >=" + val2);
	}
}