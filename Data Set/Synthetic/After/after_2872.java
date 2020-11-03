public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT  (FIRST_NAME || '  ' || LAST_NAME) NAME FROM EMPLOYEES WHERE NOT (LAST_NAME LIKE '%?%')");
		stmt.setObject(1 , str);
		ResultSet rs = stmt.executeQuery();
	}
}