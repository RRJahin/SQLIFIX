public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, JOB_ID, SALARY FROM EMPLOYEES WHERE JOB_ID <=? OR SALARY <?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val2);
		stmt.setObject(2 , rand5);
		stmt.executeQuery();
	}
}