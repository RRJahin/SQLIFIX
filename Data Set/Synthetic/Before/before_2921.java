public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT COUNT(*) FROM LOCATIONS L, COUNTRIES C WHERE L.COUNTRY_ID = C.COUNTRY_ID AND C.COUNTRY_NAME NOT LIKE '" + id1 + "%';";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}