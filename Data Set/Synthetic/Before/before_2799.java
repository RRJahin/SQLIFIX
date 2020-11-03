public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT into bestOffices(name,location) select name,location from offices   where numberEmployees >"+counter;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}