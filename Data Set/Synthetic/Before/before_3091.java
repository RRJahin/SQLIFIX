public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT REGION_ID, REGION_NAME FROM REGIONS WHERE REGION_NAME >=" + val2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}