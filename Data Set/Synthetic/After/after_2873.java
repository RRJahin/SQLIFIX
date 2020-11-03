public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT  (FIRST_NAME || '  ' || LAST_NAME) NAME FROM EMPLOYEES WHERE JOB_ID=? AND SALARY>=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id);
		stmt.setObject(2 , salary);
		stmt.executeQuery();
	}
}