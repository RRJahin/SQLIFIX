public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "Select driver_id, overall_rating from driver_performance where driver_id IN (select driver_id from driver where current_location = (select current_location from customer where customer_id =?) AND current_status =?) order by overall_rating DESC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id );
		stmt.setObject(2 , status);
		stmt.executeQuery();
	}
}