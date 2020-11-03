public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "Select T.tripId,T.customerId,T.driverId,P.totalFare From tripHistory T join payment P ON T.tripId=P.tripId where P.totalFare>=? AND (T.date<=?) order by P.totalFare DESC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , Fare);
		stmt.setObject(2 , CurrentDate);
		stmt.executeQuery();
	}
}