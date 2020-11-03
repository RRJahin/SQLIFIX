public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM LOCATIONS L, COUNTRIES C WHERE L.COUNTRY_ID = C.COUNTRY_ID AND C.COUNTRY_NAME LIKE '%" + id1 + "';");
	}
}