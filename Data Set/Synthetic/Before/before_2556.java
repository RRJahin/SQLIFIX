public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID FROM JOB_HISTORY WHERE JOB_ID <>" + var1+" OR DEPARTMENT_ID <" + rand2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}