public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, END_DATE, JOB_ID FROM JOB_HISTORY WHERE END_DATE =" + var1+" AND JOB_ID =" + rand1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}