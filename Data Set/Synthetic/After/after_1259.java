public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT COUNTRY_ID, COUNTRY_NAME, REGION_ID FROM COUNTRIES WHERE COUNTRY_NAME >? OR REGION_ID >?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var1);
		stmt.setObject(2 , rand0);
		stmt.executeQuery();
	}
}