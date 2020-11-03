public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT LOCATION_ID,(STREET_ADDRESS || ', '||CITY|| ', '|| STATE_PROVINCE|| ', '|| POSTAL_CODE) ADDRESS FROM LOCATIONS JOIN COUNTRIES USING(COUNTRY_ID) WHERE COUNTRY_NAME IN("+str1+","+str2+","+str3+")";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}