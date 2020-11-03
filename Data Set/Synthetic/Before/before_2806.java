public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT INTO DEPARTMENTS VALUES ("+number+", "+post+")";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}