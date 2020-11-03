public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "select * from employees where name="+Name;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}