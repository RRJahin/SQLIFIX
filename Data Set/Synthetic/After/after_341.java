public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, JOB_ID FROM JOB_HISTORY WHERE JOB_ID = ?");
		stmt.setObject(1 , val1);
		stmt.setObject(2 ,  );
		ResultSet rs = stmt.executeQuery();
	}
}