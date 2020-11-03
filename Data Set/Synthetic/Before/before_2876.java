public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT LOCATION_ID,(STREET_ADDRESS || ', '||CITY|| ', '|| STATE_PROVINCE|| ', '|| POSTAL_CODE) ADDRESS FROM LOCATIONS JOIN COUNTRIES USING(COUNTRY_ID) WHERE COUNTRY_NAME IN("+str1+","+str2+","+str3+")");
	}
}