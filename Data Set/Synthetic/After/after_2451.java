public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, END_DATE, JOB_ID FROM JOB_HISTORY WHERE END_DATE <=? OR JOB_ID <?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var1);
		stmt.setObject(2 , rand1);
		stmt.executeQuery();
	}
}