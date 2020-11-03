public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM Employees where id1="+id1+" and id2="+id2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}