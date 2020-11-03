public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("Select * From offer where location=? order by customerId DESC");
		stmt.setObject(1 , offerLocation);
		ResultSet rs = stmt.executeQuery();
	}
}