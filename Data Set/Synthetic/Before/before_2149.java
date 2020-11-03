public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES
SET JOB_ID = 'IT_PROG', COMMISSION_PCT = NULL
WHERE EMPLOYEE_ID <= "+id1;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}