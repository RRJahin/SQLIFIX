public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, END_DATE FROM JOB_HISTORY WHERE END_DATE <=" + var2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}