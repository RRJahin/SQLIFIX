public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select country_name from countries where length(country_name)>="+countryLength+" and region_id=( select region_id from regions where upper(region_name) like " + countryName+" )");
	}
}