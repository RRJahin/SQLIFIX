public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM LOCATIONS L, COUNTRIES C WHERE L.COUNTRY_ID = C.COUNTRY_ID AND C.COUNTRY_NAME LIKE '?%';");
		stmt.setObject(1 , id1);
		ResultSet rs = stmt.executeQuery();
	}
}