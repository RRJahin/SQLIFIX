public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select T.tripId,T.customerId,T.driverId,P.totalFare From tripHistory T join payment P ON T.tripId=P.tripId where P.totalFare>="+Fare+" AND (T.date<="CurrentDate") order by P.totalFare DESC");
	}
}