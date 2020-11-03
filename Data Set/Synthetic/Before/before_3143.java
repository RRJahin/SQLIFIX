public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT COUNTRY_ID, COUNTRY_NAME FROM COUNTRIES WHERE COUNTRY_NAME <=" + val2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}