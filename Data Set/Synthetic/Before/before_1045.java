public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, JOB_ID FROM JOB_HISTORY WHERE JOB_ID <>" + val1);
	}
}