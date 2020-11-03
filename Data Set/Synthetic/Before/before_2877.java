public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM LOCATIONS WHERE CITY LIKE \'" + name + "%\'";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}