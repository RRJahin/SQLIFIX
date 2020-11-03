public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM LOCATIONS WHERE CITY LIKE '%?';";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , name);
		stmt.executeQuery();
	}
}