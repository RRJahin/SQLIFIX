public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "select location_name from location where location_name<>(select current_location from customer where customer_id ="+id+")";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}