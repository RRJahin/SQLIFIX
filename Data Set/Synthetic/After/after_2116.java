public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE EMPLOYEES
SET JOB_ID = 'IT_PROG', COMMISSION_PCT = NULL
WHERE EMPLOYEE_ID < ?");
		stmt.setObject(1 , id1);
		ResultSet rs = stmt.executeUpdate();
	}
}