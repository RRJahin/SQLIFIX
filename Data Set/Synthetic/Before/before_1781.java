public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Employees where id="+id1);
	}
}