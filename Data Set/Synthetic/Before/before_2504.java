public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "Select * From offer where location="+offerLocation+" order by customerId DESC";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}