public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM Employees where id="+id1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}