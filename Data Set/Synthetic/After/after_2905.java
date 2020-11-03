public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM LOCATIONS WHERE COUNTRY_ID = ANY( SELECT COUNTRY_ID FROM COUNTRIES WHERE COUNTRY_NAME NOT LIKE '?%');";);
		stmt.setObject(1 , id1);
		ResultSet rs = stmt.executeQuery();
	}
}