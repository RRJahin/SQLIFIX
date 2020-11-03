public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT into bestOffices(name,location) select name,location from offices   where numberEmployees =?");
		stmt.setObject(1 , counter);
		ResultSet rs = stmt.executeQuery();
	}
}