public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM COUNTRIES WHERE COUNTRY_NAME=(SELECT COUNTRY_NAME FROM COUNTRIES WHERE population=? ORDER BY COUNTRY_NAME ASC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , number);
		stmt.executeQuery();
	}
}