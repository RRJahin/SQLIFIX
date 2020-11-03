public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM LOCATIONS WHERE COUNTRY_ID <> ANY( SELECT COUNTRY_ID FROM COUNTRIES WHERE COUNTRY_NAME LIKE '%?');";;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.executeQuery();
	}
}