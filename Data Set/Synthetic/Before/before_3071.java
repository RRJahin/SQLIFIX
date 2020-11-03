public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT REGION_ID, REGION_NAME FROM REGIONS WHERE REGION_NAME =" + val1);
	}
}