public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT INTO DEPARTMENTS VALUES ("+DEPT ID+","+DEPT NAME+", "+MANAGER ID+", "+LOCATION ID")";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}