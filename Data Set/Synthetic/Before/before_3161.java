public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT COUNTRY_ID, REGION_ID FROM COUNTRIES WHERE REGION_ID =" + val2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}