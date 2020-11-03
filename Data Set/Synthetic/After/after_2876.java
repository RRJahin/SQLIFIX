public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT LOCATION_ID,(STREET_ADDRESS || ', '||CITY|| ', '|| STATE_PROVINCE|| ', '|| POSTAL_CODE) ADDRESS FROM LOCATIONS JOIN COUNTRIES USING(COUNTRY_ID) WHERE COUNTRY_NAME IN(?,?,?)");
		stmt.setObject(1 , str1);
		stmt.setObject(2 , str2);
		stmt.setObject(3 , str3);
		ResultSet rs = stmt.executeQuery();
	}
}