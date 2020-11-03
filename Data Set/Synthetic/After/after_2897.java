public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM LOCATIONS WHERE COUNTRY_NAME  LIKE '%?' AND COUNTRY_ID = '?';";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		stmt.executeQuery();
	}
}