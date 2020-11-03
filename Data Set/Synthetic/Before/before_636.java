public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT COUNTRY_ID, COUNTRY_NAME, REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME <>" + val1+" OR REGION_ID <" + rand0);
	}
}