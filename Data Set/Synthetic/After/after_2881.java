public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM LOCATIONS WHERE CITY NOT LIKE '?%';");
		stmt.setObject(1 , name);
		ResultSet rs = stmt.executeQuery();
	}
}