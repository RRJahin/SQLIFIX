public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM LOCATIONS WHERE COUNTRY_NAME NOT LIKE '%" + id1 + "' AND COUNTRY_ID = '" + id2 + "';";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}