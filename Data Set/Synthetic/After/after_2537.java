public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select location_name from location where location_name<>(select current_location from customer where customer_id =?)");
		stmt.setObject(1 , id );
		ResultSet rs = stmt.executeQuery();
	}
}