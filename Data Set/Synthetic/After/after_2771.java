public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "select * from employees where name=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , Name);
		stmt.executeQuery();
	}
}