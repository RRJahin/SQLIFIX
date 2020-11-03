public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM Employees where id1=? and id2=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		stmt.executeQuery();
	}
}