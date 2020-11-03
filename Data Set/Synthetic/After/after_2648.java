public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select country_name from countries where length(country_name)<? and region_id=( select region_id from regions where upper(region_name) like ? )");
		stmt.setObject(1 , countryLength);
		stmt.setObject(2 , countryName);
		ResultSet rs = stmt.executeQuery();
	}
}