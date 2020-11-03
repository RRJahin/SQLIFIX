public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "Select driver_id, overall_rating from driver_performance where driver_id IN (select driver_id from driver where current_location = (select current_location from customer where customer_id ="+id+") AND current_status ="+ status+") order by overall_rating DESC";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}