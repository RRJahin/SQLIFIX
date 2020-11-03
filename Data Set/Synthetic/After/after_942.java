public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, START_DATE FROM JOB_HISTORY WHERE START_DATE >= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var1);
		stmt.setObject(2 ,  );
		stmt.executeQuery();
	}
}