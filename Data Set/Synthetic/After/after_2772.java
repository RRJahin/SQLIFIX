public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select * from employees where name=?");
		stmt.setObject(1 , Name);
		ResultSet rs = stmt.executeQuery();
	}
}