public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT into bestOffices(name,location) select name,location from offices   where numberEmployees >?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , counter);
		stmt.executeQuery();
	}
}