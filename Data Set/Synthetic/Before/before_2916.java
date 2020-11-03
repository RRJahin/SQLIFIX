public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM LOCATIONS WHERE COUNTRY_ID <> ALL( SELECT COUNTRY_ID FROM COUNTRIES WHERE COUNTRY_NAME LIKE '%" + id1 + "');");
	}
}