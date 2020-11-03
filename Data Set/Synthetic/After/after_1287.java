public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT COUNTRY_ID, COUNTRY_NAME, REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME <=? OR REGION_ID <?");
		stmt.setObject(1 , val1);
		stmt.setObject(2 , rand0);
		ResultSet rs = stmt.executeQuery();
	}
}