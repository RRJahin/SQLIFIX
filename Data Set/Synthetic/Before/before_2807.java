public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeUpdate("INSERT INTO DEPARTMENTS VALUES ("+number+", "+post+")");
	}
}