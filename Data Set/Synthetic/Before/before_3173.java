public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT COUNTRY_ID, REGION_ID FROM COUNTRIES WHERE REGION_ID >" + var1);
	}
}