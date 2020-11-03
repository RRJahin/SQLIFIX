public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT  (FIRST_NAME || '  ' || LAST_NAME) NAME FROM EMPLOYEES WHERE JOB_ID=? AND SALARY>=?");
		stmt.setObject(1 , id);
		stmt.setObject(2 , salary);
		ResultSet rs = stmt.executeQuery();
	}
}