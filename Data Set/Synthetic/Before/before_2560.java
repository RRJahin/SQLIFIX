public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select location_name from location where location_name=(select current_location from customer where customer_id ="+id+")");
	}
}