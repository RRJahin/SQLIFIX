public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, START_DATE, END_DATE FROM JOB_HISTORY WHERE START_DATE <=? AND END_DATE <?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var2);
		stmt.setObject(2 , rand0);
		stmt.executeQuery();
	}
}