public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM COUNTRIES WHERE COUNTRY_NAME=(SELECT COUNTRY_NAME FROM COUNTRIES WHERE population>"+number+" ORDER BY COUNTRY_NAME ASC";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}