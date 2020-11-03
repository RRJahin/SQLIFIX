public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES SET JOB_ID =? , COMMISSION_PCT =? WHERE EMPLOYEE_ID > ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , jobtitle);
		stmt.setObject(2 , commission);
		stmt.setObject(3 , id );
		stmt.executeUpdate();
	}
}