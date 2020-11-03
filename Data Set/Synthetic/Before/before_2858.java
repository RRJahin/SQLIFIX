public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("DELETE FROM COUNTRIES WHERE COUNTRY_NAME=(SELECT COUNTRY_NAME FROM COUNTRIES WHERE population<"+number+" ORDER BY COUNTRY_NAME ASC");
	}
}