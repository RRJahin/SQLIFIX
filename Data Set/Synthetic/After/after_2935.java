public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES WHERE HIRE_DATE <> '?';";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.executeQuery();
	}
}