public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, JOB_ID, SALARY FROM EMPLOYEES WHERE JOB_ID <>? AND SALARY <?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var1);
		stmt.setObject(2 , rand5);
		stmt.executeQuery();
	}
}