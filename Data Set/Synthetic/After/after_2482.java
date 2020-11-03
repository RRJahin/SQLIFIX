public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "Select * From offer where location=? order by customerId";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , offerLocation);
		stmt.executeQuery();
	}
}