public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES
SET JOB_ID = 'IT_PROG', COMMISSION_PCT = NULL
WHERE EMPLOYEE_ID > ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.executeUpdate();
	}
}