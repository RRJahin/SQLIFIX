public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, JOB_ID, SALARY FROM EMPLOYEES WHERE JOB_ID <=" + var2+" OR SALARY <" + rand5;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}