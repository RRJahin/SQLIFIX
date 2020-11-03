public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM COUNTRIES WHERE COUNTRY_NAME=(SELECT COUNTRY_NAME FROM COUNTRIES WHERE population<? ORDER BY COUNTRY_NAME ASC");
		stmt.setObject(1 , number);
		ResultSet rs = stmt.executeQuery();
	}
}