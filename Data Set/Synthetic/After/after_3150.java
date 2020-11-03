public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT COUNTRY_ID, COUNTRY_NAME FROM COUNTRIES WHERE COUNTRY_NAME <> ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val1);
		stmt.setObject(2 ,  );
		stmt.executeQuery();
	}
}