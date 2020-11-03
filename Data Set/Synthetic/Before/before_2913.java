public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM LOCATIONS WHERE COUNTRY_ID <> ANY( SELECT COUNTRY_ID FROM COUNTRIES WHERE COUNTRY_NAME LIKE '%" + id1 + "');";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}