public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM LOCATIONS WHERE COUNTRY_NAME NOT LIKE '" + id1 + "%' AND COUNTRY_ID = '" + id2 + "';");
	}
}