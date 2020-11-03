public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT  (FIRST_NAME || '  ' || LAST_NAME) NAME FROM EMPLOYEES WHERE NOT (LAST_NAME LIKE '%?%')";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , str);
		stmt.executeQuery();
	}
}