public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT LOCATION_ID,(STREET_ADDRESS || ', '||CITY|| ', '|| STATE_PROVINCE|| ', '|| POSTAL_CODE) ADDRESS FROM LOCATIONS JOIN COUNTRIES USING(COUNTRY_ID) WHERE COUNTRY_NAME IN(?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , str1);
		stmt.setObject(2 , str2);
		stmt.setObject(3 , str3);
		stmt.executeQuery();
	}
}