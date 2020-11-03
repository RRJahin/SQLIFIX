public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employees where id1=? and id2=?");
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		ResultSet rs = stmt.executeQuery();
	}
}