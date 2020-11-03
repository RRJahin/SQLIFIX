public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE EMPLOYEES SET JOB_ID =? , COMMISSION_PCT =? WHERE EMPLOYEE_ID = ?");
		stmt.setObject(1 , jobtitle);
		stmt.setObject(2 , commission);
		stmt.setObject(3 , id );
		ResultSet rs = stmt.executeUpdate();
	}
}