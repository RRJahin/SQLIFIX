public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT COUNTRY_ID, REGION_ID FROM COUNTRIES WHERE REGION_ID >= ?");
		stmt.setObject(1 , var2);
		stmt.setObject(2 ,  );
		ResultSet rs = stmt.executeQuery();
	}
}