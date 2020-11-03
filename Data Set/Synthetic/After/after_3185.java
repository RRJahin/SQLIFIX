public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT COUNTRY_ID, REGION_ID FROM COUNTRIES WHERE REGION_ID <= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val1);
		stmt.setObject(2 ,  );
		stmt.executeQuery();
	}
}