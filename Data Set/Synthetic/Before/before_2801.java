public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("INSERT into bestOffices(name,location) select name,location from offices   where numberEmployees >"+counter);
	}
}