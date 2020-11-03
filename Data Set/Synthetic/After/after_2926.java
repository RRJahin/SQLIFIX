public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT COUNT(*) FROM LOCATIONS L, COUNTRIES C WHERE L.COUNTRY_ID = C.COUNTRY_ID AND C.COUNTRY_NAME NOT LIKE '%?';";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.executeQuery();
	}
}