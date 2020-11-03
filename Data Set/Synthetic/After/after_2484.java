public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID FROM JOB_HISTORY WHERE JOB_ID =? AND DEPARTMENT_ID =?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var1);
		stmt.setObject(2 , rand2);
		stmt.executeQuery();
	}
}