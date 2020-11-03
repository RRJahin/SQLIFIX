public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "select L.location_name, count(Tr.start_location) AS Number_of_Trips_Last_Month from trip_history Tr RIGHT OUTER JOIN location L ON Tr.start_location = L.location_name where COALESCE(Tr.date,CURRENT_DATE)>"+Date+" group by L.location_name having count(Tr.start_location)>="+counter;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}