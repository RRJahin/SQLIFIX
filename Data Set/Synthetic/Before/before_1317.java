public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT COUNTRY_ID, COUNTRY_NAME, REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME <>" + var2+" OR REGION_ID <" + rand0;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}